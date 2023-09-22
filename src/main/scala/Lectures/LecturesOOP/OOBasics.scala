package Lectures.LecturesOOP

object OOBasics extends App {
  val person = new Person("Charlie", 14)
  println(person.age)
  person.greet("Daniel")
  person.greet()
  val newWriter = new Writer("Cormac", "McCarthy", 87)
  println(newWriter.fullName())

  val counter = new Counter()
  println(counter.inc(10).count)
}

//constructor  (Class parameters are NOT Fields add val to it)

class Person(name: String, val age: Int) {
  //body defines the implementation of this class

  //multiple constructors
  def this(name: String) = this(name, 0)

  //def methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")
  def greet(): Unit = println(s"Hi, I am $name")
}

class Writer(val fName: String, val surname: String, val year: Int) {
  def fullName(): String = s"$fName $surname"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAgeAtRelease(): Int = yearOfRelease - author.year
  def isWrittenBy(): String = author.fullName()
  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)

}

class Counter(val count: Int = 0) {
  def inc(): Counter = new Counter(this.count + 1) //immutability

  def dec(): Counter = new Counter(this.count - 1)

  def inc(n:Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

}
