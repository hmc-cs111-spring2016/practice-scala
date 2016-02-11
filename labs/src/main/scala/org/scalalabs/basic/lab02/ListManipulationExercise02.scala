package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.reduce((x, y) => math.max(x,y))
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    if (l1.isEmpty) {
      l2
    } else if (l2.isEmpty) {
      l1
    } else {
      l1.zip(l2).map(x => x._1 + x._2)
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l.reduce((l1,l2) => sumOfTwo(l1,l2))
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