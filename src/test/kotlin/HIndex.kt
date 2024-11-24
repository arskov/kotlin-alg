import kotlin.test.Test
import kotlin.test.assertEquals

object HIndex {
  class Solution {
    fun hIndex(citations: IntArray): Int {
      citations.sortDescending()
      val s = citations.size
      var i = 0
      while (i < s) {
        if (i + 1 > citations[i]) return i
        i++
      }
      return i
    }
  }

  @Test
  fun testHIndex() {
    val solution = Solution()
    assertEquals(3, solution.hIndex(intArrayOf(3, 0, 6, 1, 5)))
    assertEquals(1, solution.hIndex(intArrayOf(1, 3, 1)))
    assertEquals(1, solution.hIndex(intArrayOf(1)))
    assertEquals(0, solution.hIndex(intArrayOf(0)))
    assertEquals(0, solution.hIndex(intArrayOf()))
  }
}
