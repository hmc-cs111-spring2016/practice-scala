package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.max
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   * 
   * This was a lot more complex than expected, got confused, so I looked at the solution.
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
     (l1, l2) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (xs, ys) => xs zip ys map {case (a, b) => a + b} // I got roughly this line on my own,
                                                              // but the nil cases I was unaware of
     }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   * 
   * Again, checked in with the solution. Just wasn't sure what this one was
   * asking for.
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
        def sumOfManyNestedLists(l: List[List[Int]]): List[Int] = {
      println(l)
      l match {
        case head :: tail => sumOfTwo(head, sumOfManyNestedLists(tail))
        case Nil => Nil
      }
    }
    sumOfManyNestedLists(l.toList)
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    var youngins: ListBuffer[Person] = new ListBuffer[Person]()
    var elders: ListBuffer[Person] = new ListBuffer[Person]()
    var validYoungNames: ListBuffer[String] = new ListBuffer[String]()
    var validOldNames: ListBuffer[String] = new ListBuffer[String]()

    for (person <- persons) {
        if (person.age < 18) {
          youngins += person
        } else {
          elders += person
        }
    }

    var sortedYoung = youngins.toList.sortBy(_.age)
    var sortedOld = elders.toList.sortBy(_.age)

    for (young <- sortedYoung) {
      validYoungNames += young.firstName
    }
    for (old <- sortedOld) {
      validOldNames += old.firstName
    }
    List(validYoungNames.toList, validOldNames.toList)
  }

}