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
      case s if s.length == 1 => true
      case s1::s2::rest if s1 >= s2 => false
      case s1::rest => checkValuesIncrease(rest)
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case s if s.length == 1 => List(s)
      case s::rest => if (s == rest.head){
          var res = groupConsecutive(rest)
          List(res.head ++ List(s)) ++ res.tail
      }
      else {
        List(List(s)) ++ groupConsecutive(rest)
      }
    }
  }
  

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    in match {
      case List() => List()
      case s if s.length == 1 => List(s)
      case s::rest => List(List(s) ++ rest.filter((a) => a == s)) ++ groupEquals(rest.filter((a) => a != s))
    }
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    in match {
      case List() => List()
      case s if s.length == 1 => s
      case s::rest => List(s) ++ compress(rest.filter((a) => a != s))
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    in match {
      case List() => List()
      case s::rest => List((1 + rest.filter((a) => a == s).length, s)) ++ amountEqualMembers(rest.filter((a) => a != s))
    }
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    in match {
      case l if l.head.length == 0 => List()
      case l => List(l.map((a) => a.head)) ++ zipMultiple(l.map((a) => a.tail))
    }
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    in match {
      case l if (l.map((a) => a.length)).min == 1 => List(l.map((a) => a.head))
      case l => List(l.map((a) => a.head)) ++ zipMultipleWithDifferentSize(l.map((a) => a.tail))
    }
  }

}
