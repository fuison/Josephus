package org.scala.josephus

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object Josephus {


  def main(args: Array[String]): Unit = {
    findSafePosition(args) match {
      case Success(num) => println("SafePosition : " + num)
      case Failure(ex)  => val msg =
        if( ex.getMessage.contains("Predicate") )
          "validation error: 'numberOfPeople' needs to be (>= 1) and 'step' needs to be (>= 0)"
        else ex.getMessage
        println(s"Error : $msg")
    }
  }

  /**
    *  findSafePosition
    *  Wrap casting numberOfPeople & step into Try
    *  @param args number of people
    *  @return Try[Int] : either SafePosition as Int or error message
    */
  def findSafePosition(args: Array[String]): Try[Int] = {
    for {
      numberOfPeople  <- Try( args(0).toInt )
      step <- Try( args(1).toInt )
      if numberOfPeople >= 1 && step >= 0 //Validate numberOfPeople needs to be (>= 1) and step needs to be (>= 0)
    } yield safePosition(numberOfPeople, step )

  }


  /**
    * safePosition
    * @param numberOfPeople the number of people standing in the circle
    * @param stepRank number of people are skipped
    * @return the safe-position who will survive
    */
  def safePosition( numberOfPeople:Int, stepRank:Int):Int = {
    @tailrec
    def loop( counter:Int, partialNext:Int):Int ={
      if (counter <= numberOfPeople ) loop(counter + 1, ( partialNext + stepRank ) % counter) else partialNext + 1
    }
    loop(1,1)
  }

}


