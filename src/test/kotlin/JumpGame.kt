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
    }

    @Test
    fun testCanJumpBacktracking() {
        val solution = Solution()
        assertEquals(true, solution.canJumpBacktracking(intArrayOf(2, 3, 1, 1, 4)))
        assertEquals(false, solution.canJumpBacktracking(intArrayOf(3, 2, 1, 0, 4)))
    }
}