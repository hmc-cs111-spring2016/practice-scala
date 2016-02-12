package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to the powerful pattern matching features of Scala.
 *
 * Pattern matching can in its essence be compared to Java's 'switch' statement,
 * even though it provides many more possibilites. Whereas the Java switch statmenet
 * lets you 'match' primitive types up to int's, Scala's pattern matching goes much
 * further. Practically everything from all types of objects and Collections
 * can be matched, not forgetting xml and a special type of class called case classes.
 *
 * Pattern matching is also often used in combination with recursive algorithms.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the
 * corresponding unit test work.
 */

object PatternMatchingExercise {

  /**
   * ***********************************************************************
   *  pattern matching exercises
   * For expected solution see unittest @PatternMatchingExerciseTest
   * ***********************************************************************
   */

  def describeLanguage(s : String) : String = s match {
    case "Java" | "Smalltalk"  ⇒ "OOP"
    case "Clojure" | "Haskell" ⇒ "Functional"
    case "Scala"               ⇒ "Hybrid"
    case "C"                   ⇒ "Procedural"
    case _                     ⇒ "Unknown"
  }

  /**
   * Here's how matches should work. If `in` is:
   *
   *    - a `String`, the function result is "A string with length n"
   *       where `n` is the length of `in`
   *
   *    - a positive `Integer`, the function result is "A positive integer"
   *
   *    - an instance of class `Person`, the function result is "A person with name: n"
   *       where `n` is the name of the person
   *
   *    - a sequence with more than 10 elements, the function result is "Seq with more than 10 elements"
   *
   *    - a sequence with at least three elements, the function result is "first: v1, second: v2, rest: tail"
   *        where v1, v2, and tail are the corresponding values from the sequence
   *
   *    - null, the function result is "A null value"
   *
   *    - anything else, the function result is "Some Scala class"
   */
  def matchOnInputType(in : Any) : String = in match {
    case s : String                  ⇒ s"A string with length ${s.length}"
    case n : Int if n > 0            ⇒ "A positive integer"
    case p : Person                  ⇒ s"A person with name: ${p.name}"
    case s : Seq[_] if s.length > 10 ⇒ "Seq with more than 10 elements"
    case first :: second :: tail     ⇒ s"first: $first, second: $second, rest: $tail"
    case null                        ⇒ "A null value"
    case _                           ⇒ "Some Scala class"
  }

  /**
   * If the person is older than 30, return an `Option` with the person's name;
   *    otherwise return `None`
   */
  def older(p: Person): Option[String] = 
     if (p.age > 30) Some(p.name) else None

  /*************************************************************************
   * Pattern matching with partial functions
   * For expected solution see @PatternMatchingExerciseTest
   *************************************************************************/

  val pf1: PartialFunction[String, String] = {
    case _ => error("fix me")
  }

  val pf2: PartialFunction[String, String] = {
    case _ => error("fix me")
  }

  val pf3:PartialFunction[String, String] = {
    case _ => error("fix me")
  }

}

case class Person(name: String, age: Int)