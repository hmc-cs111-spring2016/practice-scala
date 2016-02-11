package org.scalalabs.basic.lab02
/**
 * This Lab contains exercises where the usage of
 * higher order collection methods can be rehearsed.
 */
import sys._

object CollectionExercise01 {

  /**
   * Taken from: <a href="http://code.google.com/codejam/contest/1460488/dashboard">Problem A. Speaking in Tongues</a>
   *
   * Problem
   * The aim of this task is to translate a language into a new language called Googlerese.
   * To translate we take any message and replace each English letter with another English letter.
   * This mapping is one-to-one and onto, which means that the same input letter always gets replaced
   * with the same output letter, and different input letters always get replaced with different output letters.
   * A letter may be replaced by itself. Spaces are left as-is.
   *
   * For example (and here is a hint!), the translation algorithm includes the following three mappings:
   * 'a' -> 'y', 'o' -> 'e', and 'z' -> 'q'. This means that "a zoo" will become "y qee".
   *
   * Sample Input/Output
   * Input:
   * Case 1: ejp mysljylc kd kxveddknmc re jsicpdrysi
   * Case 2: rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
   * Case 3: de kr kd eoya kw aej tysr re ujdr lkgc jv
   *
   * Output:
   * Case 1: our language is impossible to understand
   * Case 2: there are twenty six factorial possibilities
   * Case 3: so it is okay if you want to just give up
   *
   */
  def googleCodeJamGooglerese(lines: String*): Seq[String] = {
    lines.map((A) => A.map((B) => cypher(B)))
  }
  //I can't find a pattern here. so....
  def cypher(letter:Char): Char = {
    letter match {
      case 'y' => 'a'
      case 'n' => 'b'
      case 'f' => 'c'
      case 'i' => 'd'
      case 'c' => 'e'
      case 'w' => 'f'
      case 'l' => 'g'
      case 'b' => 'h'
      case 'k' => 'i'
      case 'u' => 'j'
      case 'o' => 'k'
      case 'm' => 'l'
      case 'x' => 'm'
      case 's' => 'n'
      case 'e' => 'o'
      case 'v' => 'p'
      case 'z' => 'q'
      case 'p' => 'r'
      case 'd' => 's'
      case 'r' => 't'
      case 'j' => 'u'
      case 'g' => 'v'
      case 't' => 'w'
      case 'h' => 'x'
      case 'a' => 'y'
      case 'q' => 'z'
      case ' ' => ' '
        
    }
  }
}
/*========================================================== */

object CollectionExercise02 {

  class Person(val age: Int, val name: String)

  /**
   * Take a look at the java class: {@link ImperativeSample}. The
   * groupAdultsPerAgeGroup is implemented using an imperative programming
   * style.
   * Rewrite the method groupAdultsPerAgeGroup in the ImperativeSample java class
   * using a functional approach.
   */
  def groupAdultsPerAgeGroup(persons: Seq[Person]): Map[Int, Seq[Person]] = {
    persons filter ((A) => A.age >= 18) sortBy(_.name) groupBy(_.age/10*10) 
  }
}

/*========================================================== */

object CollectionExercise03 {
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease[T <% Ordered[T]](seq: Seq[T]): Boolean =
    seq == seq.sorted

}
/*========================================================== */

object CollectionExercise04 {
  /**
   * Calculate the length of the longest word in a list of sentences.
   * To keep it simple it's ok to use String.split to extract all words of a sentence.
   */
  def calcLengthLongestWord(lines: String*): Int = {
    lines.map((l)=> l.split(' ').map((w)=> w.length).max).max
  }
}
