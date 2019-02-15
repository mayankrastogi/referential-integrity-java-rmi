package com.mayankrastogi.cs441.hw3.server

import java.rmi.RemoteException

import com.mayankrastogi.cs441.hw3.commons.{NumberWrapper, ReferenceComparer}

/**
  * Implementation of the `ReferenceComparer` trait on the server.
  */
class ReferenceComparerImplementation extends ReferenceComparer {

  @throws(classOf[RemoteException])
  override def compare(a: NumberWrapper, b: NumberWrapper): Boolean = a == b
}
