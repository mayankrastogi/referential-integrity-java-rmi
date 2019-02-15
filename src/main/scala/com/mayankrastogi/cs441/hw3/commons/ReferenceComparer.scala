package com.mayankrastogi.cs441.hw3.commons

import java.rmi.{Remote, RemoteException}

/**
  * A trait that will serve as a contract between the client and the server.
  *
  * The remote server will provide the implementation.
  */
trait ReferenceComparer extends Remote {
  /**
    * Compares the reference of two objects.
    *
    * @param a First object
    * @param b Second object
    * @throws java.rmi.RemoteException
    * @return `true` if both the objects have the same reference, `false` otherwise
    */
  @throws(classOf[RemoteException])
  def compare(a: NumberWrapper, b: NumberWrapper): Boolean
}
