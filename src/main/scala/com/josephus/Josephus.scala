package com.josephus

import scala.annotation.tailrec

/**
  * Created by vivek on 7/30/16.
  */
object Josephus extends App {

  /**
    * Recursive version of Josephus problem
    * Should use tailRec to avoid stack overflow
    *
    * @param n Number of people in the circle
    * @param k Factor by which people are eliminated
    * @return The last remaining person, if input is correct, else None
    */
  def josephusRecur (n: Int, k: Int): Option[Int] = n match {
    case 1 => Some(1)
    case num if num > 1 && k >= 1 =>
      josephusRecur(num - 1, k) match {
      case Some(lastNum: Int) => Some(1 + (lastNum + k - 1) % n)
      case None => None
    }
    case _ => None
  }

  /**
    * Recursive version printing every step of state of the circle
    *
    * @param n Number of people in the circle
    * @param k Factor by which people are eliminated
    * @return The last remaining person, if input is correct, else None
    */
  def josephusRecur2 (n: Int, k: Int): Option[Int] = {
    if (n < 1 || k < 1)
      return None

    val prisoners: List[Int] = List.range(1, n + 1)

    @tailrec
    def executePrisoner(dead: List[Int], alive: List[Int]): Option[Int] = alive match {
      case x::Nil => Some(alive.head)
      case _ =>
        //println (s"Dead: $dead, Alive: $alive")
        val group = if (alive.size < k) k - alive.size else k
        executePrisoner(dead ++ alive.slice(group - 1, group), alive.drop(group) ++ alive.take(group-1))
    }

    executePrisoner(List.empty[Int], prisoners)
  }

  /**
    * Iterative version for large n and k
    *
    * @param n Number of people in the circle
    * @param k Factor by which people are eliminated
    * @return The last remaining person, if input is correct, else None
    */

  def josephusIter(n: Int, k:Int): Option[Int] = {
    if (n < 1 || k < 1)
      return None
    var current = 1
    for (i <- 1 to n)
      current = (current + k - 1) % i + 1
    Some(current)
  }


  override def main(args: Array[String]): Unit = {
    def isNumeric(str: String) = scala.util.Try(str.toInt).isSuccess

    args.length match {
      case n if n == 2 => if (isNumeric(args(0)) && isNumeric(args(1)))
          println(s"${josephusIter(args(0).toInt, args(1).toInt)}")
      else println ("Invalid input. Usage: run <Number of people in circle> <Factor by which people are eliminated>")
      case _ => println ("Invalid input. Usage: run <Number of people in circle> <Factor by which people are eliminated>")
    }
  }
}
