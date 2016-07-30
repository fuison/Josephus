package org.scala.josephus

import scala.util.{Failure, Success}

import org.scalatest._

class JosephusSpec extends FlatSpec with Matchers {

  "Josephus: Safe Position for `numberOfPeople` = 9 & `step` = 2" should " equal 3" in {
    assert( Josephus.findSafePosition( Array("9", "2") ) === Success(3) )
  }

  "Josephus: Safe Position for `numberOfPeople` = 211 & `step` = 4" should " equal 191" in {
    assert( Josephus.findSafePosition( Array("211", "4") ) === Success(191) )
  }

  "Josephus: parameter `numberOfPeople` invalid value 'num' message" should " be (For input string: 'num')" in {
    val test = Josephus.findSafePosition(Array("num", "2")) match {
      case Failure(e) => e.getMessage
      case Success(num) => new RuntimeException("`numberOfPeople` parameter invalid test")
    }
    assert( test === """For input string: "num"""" )
  }

  "Josephus: parameter `step` invalid value 'num' message" should " be (For input string: 'num')" in {
    val test = Josephus.findSafePosition(Array("10", "num")) match {
      case Failure(e) => e.getMessage
      case Success(num) => new RuntimeException("`step` parameter invalid test")
    }
    assert( test === """For input string: "num"""" )
  }

  "Parameter validation: `numberOfPeople` needs to be (>= 1) and `step` needs to be (>= 0)" should
    " be (Predicate does not hold for 0)" in {
    val test = Josephus.findSafePosition(Array("0", "0")) match {
      case Failure(e) => e.getMessage
      case Success(num) => new RuntimeException("Parameters validation failed")
    }
    assert( test === "Predicate does not hold for 0" )
  }

  "Josephus: when `numberOfPeople` = 3 & `step` = 2 then `SafePosition`" should " equal 3" in {
    assert( Josephus.findSafePosition( Array("3", "2") ) === Success(3) )
  }

  "Josephus: when `numberOfPeople` = `step` = 4 then `SafePosition`" should " equal 2" in {
    assert( Josephus.findSafePosition( Array("4", "4") ) === Success(2) )
  }

  "Josephus: large number, when `numberOfPeople` = 3,000,000 & `step` = 2 then `SafePosition`" should " equal 180,5697" in {
    assert( Josephus.findSafePosition( Array("3000000", "2") ) === Success(1805697) )
  }

}

