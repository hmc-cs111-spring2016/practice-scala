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
      case Seq() => true
      case Seq(x) => true
      case (x :: y :: rest) => if (x < y) checkValuesIncrease(y :: rest) else false  
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  // I used the solution for this answer but played around extensively to understand it
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case (head :: _) =>
        val (same, rest) = in.span(_ == head)
        same :: groupConsecutive(rest)
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  // Here I referenced the solution but also tried it without
  // pattern matching
  def groupEquals[T](in: List[T]): List[List[T]] = {
//    in match {
//      case Nil => Nil
//      case (head :: _) =>
//        val (same, rest) = in.partition(_ == head)
//        same :: groupEquals(rest)
//    }
    (in distinct) map (x => List.fill(in.count(_ == x))(x))
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  // Here I referenced the solution but also tried it without
  // pattern matching
  def compress[T](in: List[T]): List[T] = {
//    in match {
//      case Nil => Nil
//      case a :: b :: rest if a == b => compress(a :: rest)
//      case a :: rest => a :: compress(rest)
//    }
    in distinct
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  // Here I referenced the solution but also tried it without
  // pattern matching
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    // groupEquals(in).map((l: List[T]) => (l.size, l.head))
    (in distinct) map (x => (in.count(_ == x),x))
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  // I used the solution for this answer but played around extensively to understand it
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    def flipAll(as: List[List[_]]): List[List[_]] = {
      as match {
        case Nil :: _ => Nil
        case xs => mergeFirstElement(xs) :: flipAll(removeFirstElement(xs))
      }
    }

    def mergeFirstElement(as: List[List[_]]): List[_] = {
      as match {
        case Nil => Nil
        case xs :: rest => xs.head :: mergeFirstElement(rest)
      }
    }

    def removeFirstElement(as: List[List[_]]): List[List[_]] = {
      as match {
        case Nil => Nil
        case xs :: rest => xs.tail :: removeFirstElement(rest)
      }
    }
    flipAll(in)
    
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  // I used the solution for this answer but played around extensively to understand it
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    val minLength = in.sortBy(_.size).head.size
    def dropAllListElementsLongerThan(in: List[List[_]], maxLength: Int) = {
      in.map(_.take(maxLength))
    }
    zipMultiple(dropAllListElementsLongerThan(in, minLength))
  }

}
