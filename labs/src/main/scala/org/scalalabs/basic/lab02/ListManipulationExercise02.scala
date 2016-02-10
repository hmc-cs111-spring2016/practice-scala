package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.foldLeft(l.head)((r, c) => (if (r<c) c else r))
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    if (l1.isEmpty) {
      l2
    }
    else if (l2.isEmpty) {
      l1
    }
    else {
      List(l1.head + l2.head) ++ sumOfTwo(l1.tail, l2.tail)
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l.foldLeft(List[Int]())((r, c) => (sumOfTwo(r, c)))
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    
    List(persons.filter { p:Person => (p.age<18) }.toList.sortBy(_.age).map{young => young.firstName}.toList, 
         persons.filter { p:Person => (p.age>=18) }.toList.sortBy(_.age).map{young => young.firstName}.toList)
  
  }

}