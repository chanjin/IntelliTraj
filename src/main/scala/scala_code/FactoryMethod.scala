package scala_code

/**
  * Created by chanjinpark on 2016. 8. 16..
  */

trait Animal {
  def speak() : Unit
}

object Animal {
  private class Dog extends Animal {
    override def speak() = { println("멍멍")}
  }
  private class Cat extends Animal {
    override def speak() = { println("야옹")}
  }

  def apply(s: String): Animal = {
    s match {
      case "Cat" => new Cat
      case "Dog" => new Dog
      case _ => null
    }
  }
}

object FactoryMethod {
  def main(args: Array[String]): Unit = {
    //new Animal("Dog").speak()
    Animal("Dog").speak()
    Animal("Cat").speak()
  }
}
