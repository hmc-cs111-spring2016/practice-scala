package org.scalalabs.basic.lab03
import scala.util.control._
import sys._

package object lab03 {

  /**
   * This map contains sample testdata to clarify this exercise.
   * It contains key value pairs where:
   * - the key is a room number
   * - the value can be:
   * -- the amount of people in the room (filled: Some("10"), empty: None)
   * -- the room is not available (Some("locked"))
   */
  val sampleRooms = Map(1 -> Some("12"), 2 -> None, 3 -> Some("locked"), 4 -> Some("14"), 5 -> Some("8"), 6 -> Some("locked"))
}

object OptionExercise01 {

  /**
   * Implement the room state method that should return the state of a room as a String as follows:
   * - filled: return total people:     E.g: Some("12") is "12"
   * - locked: return "not available"   E.g. Some("locked") is "not available"
   * - empty:  return "empty"	        E.g. None is "empty"
   * - does not exist: 					"not existing"
   */
  def roomState(rooms: Map[Int, Option[String]], room: Int): String = {
    rooms.get(room) match {
      case Some(Some("locked")) => "not available"
      case Some(Some(value)) => value
      case Some(None) => "empty"
      case None => "not existing"
    }
  }
}

object OptionExercise02 {
  /**
   * Calculate the total amount of people in all rooms
   * Hint: define a helper function that computes a room's occupancy
   * to convert a possible numeric String (e.g. Some("12")) to an integer
   */
  def totalPeopleInRooms(rooms: Map[Int, Option[String]]): Int = {
    // tail recursion to simplify getting set of keys
    tailTotal(rooms, rooms.keys)
  }
  
  def tailTotal(rooms: Map[Int, Option[String]], keys: Iterable[Int]): Int = {
    if (keys.isEmpty) {
      0
    } else {
      rooms.get(keys.head) match {
        case Some(Some(value)) if value != "locked" => value.toInt + tailTotal(rooms, keys.tail) // if there is an element, add it to the sum of the tail
        case _ => 0 + tailTotal(rooms, keys.tail) // if there are no elements, then the sum is 0
      }
    }
  }
}