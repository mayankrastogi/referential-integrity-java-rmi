package com.mayankrastogi.cs441.hw3.server

import java.rmi.server.UnicastRemoteObject
import java.rmi.{Naming, RemoteException}

import com.mayankrastogi.cs441.hw3.commons.ReferenceComparer
import com.typesafe.scalalogging.LazyLogging

/**
  * The server that makes the remote object available to the client.
  *
  * Make sure that the RMI registry service is started before running the server. Additionally, ensure that the RMI
  * registry is run from the root of the class files (`[project-dir]/target/scala-2.12/classes`), otherwise the server
  * will throw an exception.
  *
  * See <a href="https://stackoverflow.com/a/33601400/4463881">this answer</a> at StackOverflow.
  */
object Server extends LazyLogging {

  def main(args: Array[String]): Unit = {
    try {
      logger.info("Starting server...")

      // Create the remote object (which is local for the server :p)
      val obj = new ReferenceComparerImplementation
      logger.trace("Object created.")

      // Export the object so that it can be invoked remotely
      val stub = UnicastRemoteObject.exportObject(obj, 0).asInstanceOf[ReferenceComparer]
      logger.trace("Stub created for the object.")

      // Register the object with the RMI registry
      Naming.rebind("ReferenceComparer", stub)
      logger.trace("Registered the stub with RMI registry")

      logger.info("Server is ready.")
    }
    catch {
      case e: RemoteException =>
        logger.error("Could not contact the RMI registry. Please make sure that the RMI registry service is running and that it was started from the root of the class files (target/scala-2.12/classes): ", e)
        e.printStackTrace()

      case e: Exception =>
        logger.error("Server exception: ", e)
        e.printStackTrace()
    }
  }
}
