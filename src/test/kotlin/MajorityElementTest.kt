import kotlin.test.Test
import kotlin.test.assertEquals

object MajorityElementTest {

    fun majorityElement(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        val cache = mutableMapOf<Int, Int>()
        for (n in nums) {
            cache[n] = cache.getOrPut(n) { 1 } + 1
        }
        val maxEntry = cache.maxBy { it.value }
        return maxEntry.key
    }

    fun majorityElementWithSort(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        nums.sort()
        return nums[nums.size / 2]
    }

    @Test
    fun testMajorityElement() {
        val in1 = intArrayOf(3, 2, 3)
        val res1 = majorityElement(in1.copyOf())
        val res1s = majorityElementWithSort(in1.copyOf())
        assertEquals(3, res1)
        assertEquals(3, res1s)

        val in2 = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val res2 = majorityElement(in2.copyOf())
        val res2s = majorityElementWithSort(in2.copyOf())
        assertEquals(2, res2)
        assertEquals(2, res2s)

        val in3 = intArrayOf(1, 5, 1)
        val res3 = majorityElement(in3.copyOf())
        val res3s = majorityElementWithSort(in3.copyOf())
        assertEquals(1, res3)
        assertEquals(1, res3s)

        val in4 = intArrayOf(-1, 100, 2, 100, 100, 4, 100)
        val res4 = majorityElement(in4.copyOf())
        val res4s = majorityElementWithSort(in4.copyOf())
        assertEquals(100, res4)
        assertEquals(100, res4s)

        val in5 = intArrayOf(-1, 1, 1, 1, 2, 1)
        val res5 = majorityElement(in5.copyOf())
        val res5s = majorityElementWithSort(in5.copyOf())
        assertEquals(1, res5)
        assertEquals(1, res5s)
    }
}