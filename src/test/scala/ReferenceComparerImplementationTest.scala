import com.mayankrastogi.cs441.hw3.commons.NumberWrapper
import com.mayankrastogi.cs441.hw3.server.ReferenceComparerImplementation
import org.junit.Assert._
import org.junit.{Before, Test}

class ReferenceComparerImplementationTest {
  var referenceComparer: ReferenceComparerImplementation = _

  @Before def setUp(): Unit = {
    referenceComparer = new ReferenceComparerImplementation
  }

  @Test def testCompareDifferentObjects(): Unit = {
    val a = new NumberWrapper(10)
    val b = new NumberWrapper(20)

    assertFalse(referenceComparer.compare(a, b))
  }

  @Test def testCompareSameObjects(): Unit = {
    val a = new NumberWrapper(10)
    val b = a

    assertTrue(referenceComparer.compare(a, b))
  }
}
