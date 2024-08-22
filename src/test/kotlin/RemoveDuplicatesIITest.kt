import kotlin.test.Test
import kotlin.test.assertContentEquals

object RemoveDuplicatesIITest {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var i = 2
        for (j in 2 until nums.size) {
            if (nums[j] != nums[i-2]) {
                nums[i] = nums[j]
                i++
            }
        }
        return i
    }

    @Test
    fun removeDuplicatesTest() {
        val test1 = intArrayOf(1, 1, 2)
        val resSize1 = removeDuplicates(test1)
        val res1 = test1.copyOf(resSize1)
        assertContentEquals(intArrayOf(1, 1, 2), res1)

        val test2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val resSize2 = removeDuplicates(test2)
        val res2 = test2.copyOf(resSize2)
        assertContentEquals(intArrayOf(0, 0, 1, 1, 2, 2, 3, 3, 4), res2)

        val test3 = intArrayOf(1)
        val resSize3 = removeDuplicates(test3)
        val res3 = test3.copyOf(resSize3)
        assertContentEquals(intArrayOf(1), res3)

        val test4 = intArrayOf()
        val resSize4 = removeDuplicates(test4)
        val res4 = test4.copyOf(resSize4)
        assertContentEquals(intArrayOf(), res4)
    }
}

