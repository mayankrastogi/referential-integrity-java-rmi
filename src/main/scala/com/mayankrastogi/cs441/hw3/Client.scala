package com.mayankrastogi.cs441.hw3

import java.rmi.Naming

import com.mayankrastogi.cs441.hw3.commons.{NumberWrapper, ReferenceComparer}
import com.typesafe.scalalogging.LazyLogging

/**
  * The client program.
  */
object Client extends LazyLogging {

  private val remoteObject = Naming.lookup("ReferenceComparer").asInstanceOf[ReferenceComparer]

  def main(args: Array[String]): Unit = {
    try {

      // Test case 1: Both the objects wrap the same number but are different instances of `NumberWrapper`

      val number1 = new NumberWrapper(5)
      logger.info("number1 is an object that wraps the number 5")

      val number2 = new NumberWrapper(5)
      logger.info("number2 is a different object that wraps the same number 5")

      val resultWithDifferentObjects = compareReferences(number1, number2)
      logger.info("Is number1 the same object as number2 on remote? " + resultWithDifferentObjects)


      // Test case 2: Second object is an alias of the first object

      logger.info("number1 is an object that wraps the number 5")

      val number1Alias = number1
      logger.info("number1Alias references the same object as number1 locally")

      val resultWithSameObjects = compareReferences(number1, number1Alias)
      logger.info("Is number1 the same object as number1Alias on remote? " + resultWithSameObjects)
    }
    catch {
      case e: Exception =>
        logger.error("Client exception: ", e)
        e.printStackTrace()
    }
  }

  /**
    * Invokes the remote method and prints logs to compare references of two objects.
    *
    * @param a First object
    * @param b Second object
    * @return `true` if both the objects have the same reference, `false` otherwise
    */
  def compareReferences(a: NumberWrapper, b: NumberWrapper): Boolean = {
    logger.trace("Invoking remote method...")

    val result = remoteObject.compare(a, b)

    logger.trace("Remote method returned the value: " + result)

    result
  }
}
