import kotlin.test.Test
import kotlin.test.assertEquals

object JumpGame2 {

  class Solution {
    fun jumpDpMemo(nums: IntArray): Int {
      val n = nums.size
      val memo = IntArray(n) { -1 } // Initialize memoization array with -1 (unvisited)

      // Recursive function with memoization
      fun dp(index: Int): Int {
        if (index >= n - 1) return 0 // Base case: already at or beyond the last index
        if (memo[index] != -1) return memo[index] // Return memoized result if available

        var minSteps = Int.MAX_VALUE
        val maxJump = nums[index]
        for (jump in 1..maxJump) {
          if (index + jump < n) {
            val step = dp(index + jump)
            if (step != Int.MAX_VALUE) {
              minSteps = minOf(minSteps, 1 + dp(index + jump))
            }
          }
        }
        memo[index] = minSteps // Store the result in the memoization array
        return minSteps
      }

      return dp(0) // Start from the first index
    }

    fun jumpGreedy(nums: IntArray): Int {
      val s = nums.size
      if (s <= 1) return 0
      var curFar = 0
      var curEnd = 0
      var jump = 0
      for (i in 0 until s - 1) {
        curFar = maxOf(curFar, i + nums[i])
        if (i == curEnd) {
          jump += 1
          curEnd = curFar
        }
      }
      return jump
    }
  }

  @Test
  fun testJumpGame1() {
    val solution = Solution()
    assertEquals(2, solution.jumpDpMemo(intArrayOf(2, 3, 1, 1, 4)))
    assertEquals(2, solution.jumpDpMemo(intArrayOf(2, 3, 0, 1, 4)))
    assertEquals(Int.MAX_VALUE, solution.jumpDpMemo(intArrayOf(3, 2, 1, 0, 4)))
    assertEquals(2, solution.jumpGreedy(intArrayOf(2, 3, 1, 1, 4)))
    assertEquals(2, solution.jumpGreedy(intArrayOf(2, 3, 0, 1, 4)))
    // Greedy approach doesn't work in case if the array contains unreachable last step
    // assertEquals(Int.MAX_VALUE, solution.jumpGreedy(intArrayOf(3, 2, 1, 0, 4)))
  }
}
