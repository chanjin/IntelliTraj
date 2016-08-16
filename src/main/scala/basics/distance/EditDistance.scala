package basics.distance

/**
  * Created by chanjinpark on 2016. 8. 13..
  */
class EditDistance[T] {

  def distance1(a: Array[T], b: Array[T]): Int = {
    0
  }

  def min(a: Int, b: Int, c: Int) = {
    if ( a < b ) {
      if ( a < c ) a else c
    }
    else {
      if ( b < c ) b else c
    }
  }


  def distance(a: Array[Char], b: Array[Char]): Int = {

    def dist(i: Int, j: Int) : Int = {
      if ( i == 0 ) return j
      if ( j == 0 ) return i
      val cost = if ( a(i - 1 ) == b(j - 1)) 0 else 1
      min( dist(i - 1, j) + 1, dist(i, j - 1) + 1, dist(i - 1, j - 1) + cost)
    }

    if ( a.length == 0 ) b.length
    else if (b.length == 0 ) a.length
    else {
      dist(a.length, b.length)
    }
  }
}

object EditDistance {
  def main(args: Array[String]): Unit = {

    val d = new EditDistance[Char]
    assert(d.distance("geak".toArray, "geak1".toArray) == 1)

    //assert(d.distance("geak", "geak1") == 1)

    println(d.distance("SPARTAN".toArray, "PART".toArray))
    println(d.distance("PLASMA".toArray, "ALTRUISM".toArray))
  }
}
