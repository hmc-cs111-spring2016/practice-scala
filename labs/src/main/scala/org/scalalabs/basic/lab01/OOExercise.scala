package org.scalalabs.basic.lab01
import scala.language.implicitConversions
/**
 * The goal of this exercise is to get familiar basic OO constructs in scala
 *
 * Fix the code so that the unit test 'CurrencyExerciseTest' passes.
 *
 * In order for the tests to pass you need to do the following:
 * 
 * Exercise 1:
 * - Create a class Euro
 * - Provide it with two constructor parameters: euro:Int, cents:Int
 * - Provide the cents field with default value: 0
 * - Provide an immutable field named: inCents that converts euro + cents into cents.
 * - Create an object Euro with a factory method named: fromCents that creates an Euro based on cents.
 * - Create a method named: + to the Euro class that adds another Euro
 * - Create a method named: * to the Euro class that multiplies an Euro by an integer
 * 
 * Exercise 2:
 * - Create an abstract class Currency
 * - Provide it with one constructor parameter: symbol:String
 * - Extend the previously created Euro class from Currency
 * - Override the toString method of Euro to represent the following String:
 *   -> symbol + ': ' + euro + ',' + cents.  E.g: EUR 200,05
 * - In case the cents are 0 use this representation:
 *   -> symbol + ': ' + euro + ',--. E.g.: EUR 200,--
 *   
 * OPTIONAL: Exercise 3:
 * - Mix the Ordered trait in Euro
 * - Implement the compare method  
 * 
 * OPTIONAL: Exercise 4:
 * - Provide an implicit class that adds a *(euro:Euro) method to Int
 * - Create a new currency Dollar
 * - Provide a implicit conversion method that converts from Euro to Dollar using the 
 *   [[org.scalalabs.basic.lab01.DefaultCurrencyConverter]]
 * 
 * OPTIONAL: Exercise 5:
 * - Extend the conversion method from Euro to Dollar with an implicit parameter 
 *   of type [[org.scalalabs.basic.lab01.CurrencyConverter]]
 * - Use the implicit CurrencyConverter to do the conversion. 
 */

class Euro(var euro:Int, var cents:Int = 0) extends Currency() {
  def inCents:Int = euro + cents
  
  def +(euroTwo:Euro):Euro = {
    new Euro(euro + euroTwo.euro, cents + euroTwo.cents)
  }
  
  def *(multVal:Int):Euro = {
    val s = inCents * multVal
    val newEuros = s - (s/100)
    val newCents = s - newEuros
    new Euro(newEuros, newCents)
  }
  
  override def toString():String = {
    if(cents == 0) {
      symbol + ": " + euro + ",--"
    }else {
      symbol + ": " + euro + ',' + cents
    }
  }
}

object Euro {
  def fromCents(initialCents:Int):Euro = {
    val newEuros = initialCents - (initialCents/100)
    val newCents = initialCents - newEuros
    new Euro(newEuros, newCents)
  }
}

abstract class Currency(val symbol:String = "EUR")
