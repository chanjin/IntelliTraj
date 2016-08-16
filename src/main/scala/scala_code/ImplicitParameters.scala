package scala_code

/**
  * Created by chanjinpark on 2016. 8. 16..
  */

class X(val i: Int) {
  def add(implicit x: X) = println(x.i + i)
}
object X {
  implicit def xx = new X(3)
}

abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}
abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
}


object ImplicitParameters {

  def main(args: Array[String]): Unit = {
    /*
      When a method requires an implicit there are several ways that the implicit is resolved.
      One way is to search for an implicit definition in the companion object of the required type.
      For example: def x(implicit m:MyClass) parameter m will search local scope, class hierarchy and
      the MyClass companion object for an implicit val or def. (More on implicit resolution later).
     */
    println("--- 1")
    new X(3).add
    val other = new {
      def print(implicit x: X) = println(x.i)
    }
    other.print
    implicit def x = new X(32)
    other.print

    println("--- 2")
    /*
      아래 예제에서는 모노이드의 add와 unit메서드를 이용해서 리스트 항목들의 합을 구하는 sum 메서드를 정의한다.
      암시적 값은 최상위 레벨이 될 수 없고 템플릿의 멤버여야만 한다는 점에 주의하자.
     */
    implicit object StringMonoid extends Monoid[String] {
      def add(x: String, y: String): String = x concat y
      def unit: String = ""
    }
    implicit object IntMonoid extends Monoid[Int] {
      def add(x: Int, y: Int): Int = x + y
      def unit: Int = 0
    }
    def sum[A](xs: List[A])(implicit m: Monoid[A]): A = {
      if (xs.isEmpty) m.unit
      else m.add (xs.head, sum (xs.tail) )
    }

    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))
  }
}
