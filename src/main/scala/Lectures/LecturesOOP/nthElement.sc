import scala.annotation.tailrec

trait LIST[T] {
  def isEmpty: Boolean
  def head: T
  def tail: LIST[T]
}

class CONS[T](val head: T, val tail: LIST[T]) extends LIST[T] {
  def isEmpty = false
}

class NIL[T] extends LIST[T] {
  def isEmpty = false
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

@tailrec
def nth[T](xs: LIST[T], n: Int): T = {
  if (xs.isEmpty) throw new IndexOutOfBoundsException()
  else if (n == 0) xs.head
  else nth(xs.tail, n - 1)
}

