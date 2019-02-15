package com.mayankrastogi.cs441.hw3.commons

import java.io.Serializable

/**
  * Simple class that wraps a Scala `Int`.
  *
  * Objects of this class will be passed to the remote method.
  *
  * @param n An integer
  */
class NumberWrapper(n: Int) extends Serializable
