package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
import sys._

object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.foldLeft(0)(
      (a, b) => math.max(a, b))
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {

    (l1, l2) match {
      case (Nil, Nil)         => Nil
      case (x :: xs, Nil)     => x :: (sumOfTwo(xs, Nil))
      case (Nil, x :: xs)     => x :: (sumOfTwo(Nil, xs))
      case (x :: xs, y :: ys) => (x + y) :: (sumOfTwo(xs, ys))
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    def mySumOfMany(l: List[List[Int]]): List[Int] = {
      l match {
        case Nil       => Nil
        case (x :: xs) => sumOfTwo(x, mySumOfMany(xs))
      }
    }

    mySumOfMany(l.toList)

    //so '*' means array?
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    
    List(persons.filter(p => p.age < 18).sortBy(_.age).map(f => f.firstName), persons.filter(p => p.age >= 18).sortBy(_.age).map(g => g.firstName))
  }

}