package trajectorymining.noisefilter

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.joda.time.{DateTime, DateTimeZone}

/**
  * Created by chanjinpark on 2016. 8. 16..
  */
class LoadTrajectories {

}

class Point(val latitude: Float, val longitude: Float, val ts: DateTime) extends Serializable {
  override def toString = latitude + ", " + longitude + ", " + ts
}
class Trajectory(val userid: Int, val sessionid: String, val pts: Array[Point]) extends Serializable { }



object LoadTrajectories {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true).setMaster("local").setAppName("NSFLDA")
    val sc = new SparkContext(conf)
    Logger.getLogger("org").setLevel(Level.ERROR)
    val path = "/Users/chanjinpark/data/Geolife Trajectories 1.3/sample/*/Trajectory/*.plt"
    val files = sc.wholeTextFiles(path)
    val parsed = files.map(parseLine(_))

    parsed.first.pts.take(3).foreach(p => println(p.ts))
  }

  def parseLine(s: (String, String)): Trajectory = {
    val prefix = "file:/Users/chanjinpark/data/Geolife Trajectories 1.3/sample/"
    val remaining = s._1.substring(prefix.length)
    val userid = remaining.substring(0, remaining.indexOf("/")).toInt
    val sessionid = remaining.substring(remaining.lastIndexOf("/") + 1, remaining.lastIndexOf("."))

    new Trajectory(userid, sessionid, parseTrajectory(s._2))
  }

  def parseTrajectory(s: String): Array[Point] = {
    s.split("\n").drop(6).map(s => {
      val d = s.split(",").map(_.trim)
      //40.004171,  116.321683, 0,  492,  39965.3538425926, 2009-06-01,08:29:32
      val date = d(5).split("-").map(_.toInt)
      val time = d(6).split(":").map(_.toInt)

      DateTimeZone.setDefault(DateTimeZone.UTC) // Default Time Zone을 GMT로 설정. 파일의 시간이 GMT이므로
      new Point(d(0).toFloat, d(1).toFloat,
        new DateTime(date(0), date(1), date(2), time(0), time(1), time(2)))
    })
  }
}