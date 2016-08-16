package trajectorymining.noisefilter

/**
  * Created by chanjinpark on 2016. 8. 16..
  */
class GeoMap {

}

class Rect(val x0: Float, val y0: Float, val x1: Float, val y1: Float) {
  def ptInRect(x: Float, y: Float): Boolean =
    x0 <= x && x < x1 && y0 <= y && y < y1

  override def toString(): String = {
    f"($x0%3.5f, $y0%3.5f, $x1%3.5f, $y1%3.5f)"
  }
}

object Rect {
  def apply(x: Float, y: Float, unit: Float): Rect = {
    new Rect(x, y, x + unit, y + unit)
  }


}

class Grid(val left: Float, val right: Float, val bottom: Float, val top: Float, val unit: Float) {
  assert(left < right && bottom < top)

  val rects = (left until right by unit).map(x =>
      (bottom until top by unit).map(y => Rect(x, y, unit)).toArray[Rect]
    ).toArray[Array[Rect]]

  def getRect(x: Float, y: Float): Rect = {
    if (x < left || x > right || y < bottom || y > top) return null
    rects(((x - left) / unit).toInt)(((y - bottom) / unit).toInt)
  }

  def getRect(p: Point): Rect = getRect(p.longitude, p.latitude)

  def getRect(t: Trajectory): List[Rect] = {
    t.pts.map(pt => getRect(pt)).toList
  }
}

object GeoMap {
  //val rectBeijing = ((39.7, 40.0), (116.0, 116.8))
  implicit def cast(d: Double):Float = d.toFloat

  val grid = new Grid(116.28.toFloat, 116.33.toFloat, 39.97.toFloat, 40.01.toFloat, 0.001.toFloat)

  def main(args: Array[String]): Unit = {
    val r = grid.getRect(116.33, 39.99)
    println(r.x0)
    println(r.y0)
  }
}