package Lectures.LecturesOOP

import scala.language.postfixOps

object Notations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie:String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")
  println(mary.likes("Inception"))
  println(mary likes "Inception")  //equivalent (Infix or operator notation (works with methods with 1 parameter)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2)) //equivalent

  //ALL OPERATORS IN SCALA are METHODS

  // "oprerators" in Scala

  //Prefix notation - Unary Operators

  val x = -1
  val y = 1.unary_- //equivalent
  println(!mary)
  println(mary.unary_!)
  //unary_prefix only works with - + ~ !

  //Postfix notation - if a method doesnt receive any parameters requires import

  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())  //equivalent
}
