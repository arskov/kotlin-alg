import kotlin.test.Test
import kotlin.test.assertContentEquals

object RemoveElementTest {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        var j = 0
        for (v in nums) {
            if (v != `val`) nums[j++] = v
        }
        return j
    }

    @Test
    fun removeElementTest() {
        val test1 = intArrayOf(3, 2, 2, 3)
        val resSize1 = removeElement(test1, 3)
        val res1 = test1.copyOf(resSize1)
        assertContentEquals(intArrayOf(2, 2), res1)

        val test2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val resSize2 = removeElement(test2, 2)
        val res2 = test2.copyOf(resSize2)
        assertContentEquals(intArrayOf(0, 1, 3, 0, 4), res2)
    }
}
