import kotlin.test.Test
import kotlin.test.assertEquals

object JumpGame {

    class Solution {

        fun canJumpBacktracking(nums: IntArray): Boolean {
            fun canJumpInternal(nums: IntArray, i: Int): Boolean {
                if (i == nums.size - 1) {
                    return true
                }
                val maxJump = minOf(nums[i] + i, nums.size - 1)
                for (j in ((i + 1)..maxJump)) {
                    if (canJumpInternal(nums, j)) return true
                }
                return false
            }
            return canJumpInternal(nums, 0)
        }

        fun canJumpBacktrackingMemo(nums: IntArray): Boolean {
            val memo = mutableMapOf<Int, Boolean?>()
            fun canJumpInternal(nums: IntArray, i: Int): Boolean {
                memo[i]?.let {
                    return it
                }
                if (i == nums.size - 1) {
                    memo[i] = true
                    return true
                }
                val maxJump = minOf(nums[i] + i, nums.size - 1)
                for (j in ((i + 1)..maxJump)) {
                    if (canJumpInternal(nums, j)) {
                        memo[i] = true
                        return true
                    }
                }
                memo[i] = false
                return false
            }
            return canJumpInternal(nums, 0)
        }

        fun canJumpBottomUp(nums: IntArray): Boolean {
            val n = nums.size
            val dp = BooleanArray(n)
            dp[0] = true
            for (i in 0 until n) {
                if (dp[i]) {
                    val maxFurther = minOf(i + nums[i], n - 1)
                    for (j in i..maxFurther) dp[j] = true
                }
                if (dp[n - 1]) return true
            }
            return dp[n - 1]
        }
    }

    @Test
    fun testCanJumpBacktracking() {
        val solution = Solution()

        assertEquals(true, solution.canJumpBacktracking(intArrayOf(2, 3, 1, 1, 4)))
        assertEquals(false, solution.canJumpBacktracking(intArrayOf(3, 2, 1, 0, 4)))

        assertEquals(true, solution.canJumpBacktrackingMemo(intArrayOf(2, 3, 1, 1, 4)))
        assertEquals(false, solution.canJumpBacktrackingMemo(intArrayOf(3, 2, 1, 0, 4)))

        assertEquals(true, solution.canJumpBottomUp(intArrayOf(2, 3, 1, 1, 4)))
        assertEquals(false, solution.canJumpBottomUp(intArrayOf(3, 2, 1, 0, 4)))
    }
}