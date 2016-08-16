package trajectorymining.noisefilter

import java.io.File
import java.util.TimeZone

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.joda.time._

/**
  * Created by chanjinpark on 2016. 8. 16..
  */





object NoiseFiltering {

  val workspace = "./geolifedatasample"
  def loadTrajectories() = {

  }

  def listFilesForFolder(folder: File) = {
    val users = folder.listFiles().filter(_.isDirectory).map(_.getName)
    users.map(dn => {
      val tdir = new File(folder.getPath + "/" + dn + "/Trajectory")
      (dn, tdir.listFiles().filter(f => f.isFile && f.getName.lastIndexOf(".plt") > 0 ).
        map(f => (f.getName, scala.io.Source.fromFile(f).getLines().toArray)))
    })
  }

  def readDirectory(dir: String) = {
    listFilesForFolder(new File(dir)).flatMap(ut => ut._2.map(ft => LoadTrajectories.makeTrajectory(ut._1, ft._1.substring(0, ft._1.lastIndexOf(".")), ft._2)))
  }

  def getGridSize(ts: Array[Trajectory]) = {
    val pts = ts.flatMap(t => t.pts.map(pt => (pt.latitude, pt.longitude)))
    val (minmaxLat, minmaxLon) = pts.tail.foldLeft(((pts.head._1, pts.head._1), (pts.head._2, pts.head._2)))((res, pt) => {
      val ((minLat, maxLat), (minLon, maxLon)) = res
      ((if (pt._1 < minLat) pt._1 else minLat, if (pt._1 > maxLat) pt._1 else maxLat),
        (if (pt._2 < minLon) pt._2 else minLon, if (pt._2 > maxLon) pt._2 else maxLon))
    })

    ((minmaxLat._1, minmaxLat._2), (minmaxLon._1, minmaxLon._2))
  }

  def duplicateRects(rects: List[Rect]) = {
    var prev = rects.head
    var count = 1
    var result = List[(Rect, Int)]()
    rects.tail.foreach(r => {
      if (r.equals(prev)) count = count + 1
      else {
        result = (r, count) :: result
        prev = r
        count = 1
      }
    })
    result = (prev, count) :: result
    result.reverse
  }

  def main(args: Array[String]): Unit = {

    //val t: Trajectory= LoadTrajectories.parseLine(datasample)
    // t.pts.zip(GeoMap.grid.getRect(t)).foreach(println)
    println()
    val ts: Array[Trajectory] = readDirectory(workspace)
    println(ts.size)
    ts.take(3).foreach(t => println(t.userid + "\t" + t.sessionid + "\t" + t.pts.take(3).mkString(" -> ")))

    println()

    val gsize = getGridSize(ts)
    val unit = 0.002.toFloat

    println(((gsize._2._2 - gsize._2._1) * (1/unit), (gsize._1._2 - gsize._1._1) * (1/unit)))

    val grid = new Grid(gsize._2._1, gsize._2._2 + unit, gsize._1._1, gsize._1._2 + unit, unit)

    println(ts(0).pts.size)
    //val rects = grid.getRect(ts(0)).zip(ts(0).pts)
    //val rectsGroups = rects.groupBy(_._1).map(gs => (gs._1, gs._2.size))
    grid.getRect(ts(0)).foreach(println)
    println("-------")
    println(duplicateRects(grid.getRect(ts(0))).length)
    duplicateRects(grid.getRect(ts(0))).foreach(println)

    ts.map(t => (t.sessionid, grid.getRect(t).size)).foreach(println)
  }
}
