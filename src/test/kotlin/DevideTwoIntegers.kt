import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.math.abs

object DevideTwoIntegers {
  class Solution {
    fun fun divide(dividend: Int, divisor: Int): Int {
      if (dividend == Int.MAX_VALUE && divisor == -1)
        return Int.MAX_VALUE
      val isNegative = (dividend < 0) xor (divisor < 0)
      var dividend = abs(dividend)
      val divisor = abs(divisor)
      var quotient = 0
      while (dividend >= divisor) {
        var tmp = divisor
        var mul = 1
        while (dividend >= (tmp shl 1)) {
          tmp = tmp shl 1
          mul = mul shl 1
        }
        quotient += mul
        dividend -= tmp
      }
      return if (isNegative) -qotient else quotient
    }
  }

  @Test
  fun testDevideTwoInteger() {
    val solution = Solution()
    assertEquals(3, solution.devide(10, 3))
    assertEquals(-3, solution.devide(10, -3))
  }
}
    
