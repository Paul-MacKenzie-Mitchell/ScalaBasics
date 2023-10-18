

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(s: IntSet): IntSet
}

class Empty() extends IntSet {
  def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())

  def contains(x: Int): Boolean = false

  def union(s: IntSet): IntSet = s
}



class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet =
    if (x < elem) NonEmpty(elem, left.incl(x), right)
    else if (x > elem) NonEmpty(elem, left, right.incl(x))
    else this

  def contains(x: Int): Boolean =
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true

  def union(s: IntSet): IntSet =
    left.union(right).union(s).incl(elem)
}

