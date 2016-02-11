package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true 
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    seq match {
      case first::second::rest if second > first => checkValuesIncrease(second::rest)
      case first::second::rest if second <= first => false
      case first::rest => true
      case Nil => true

    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    val group = in.takeWhile(_ == in.head)
    if (group.length == in.length) {
      List(group)
    } else {
        group::groupConsecutive(in.drop(group.length))
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    val subList = in.filter(_ == in.head)
    val remainder = in.filter(_ != in.head)

    if (remainder.isEmpty) {
      List(subList)
    } else{
        subList::groupEquals(remainder)
    }

  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    in match {
      case first::rest => first::compress(rest.filter(_ != first))
      case Nil => List.empty[T]
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    in match {
      case first::rest => ((in.filter(_ == first)).length, first)::amountEqualMembers(rest.filter(_ != first))
      case Nil => List.empty[(Int, T)]
    }
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    in match{
      case first::rest if (!first.isEmpty) => (in.map(list => list.head))::zipMultiple(in.map(list => list.tail))
      case _ => List.empty[List[_]]
    }

    //This method also works but I wanted to try to put it into a pattern matching case
    // if(in.head.isEmpty) {
    //   List.empty[List[_]]
    //   } else {
    //       val first = in.map(list => list.head)
    //       val rest = in.map (list => list.tail)
    //       first::zipMultiple(rest)
    //   }

  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    if(in.exists(_.isEmpty)) {
      List.empty[List[_]]
      } else {
          val first = in.map(list => list.head)
          val rest = in.map (list => list.tail)
          first::zipMultipleWithDifferentSize(rest)
      }
  }

}


























