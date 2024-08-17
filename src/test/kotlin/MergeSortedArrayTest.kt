import kotlin.test.Test
import kotlin.test.assertContentEquals

object MergeSortedArrayTest {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        for (k in (m + n - 1) downTo 0) {
            nums1[k] = if (i >= 0 && j < 0) {
                nums1[i--]
            } else if (i < 0 && j >= 0) {
                nums2[j--]
            } else if (nums1[i] > nums2[j]) {
                nums1[i--]
            } else {
                nums2[j--]
            }
        }
    }

    @Test
    fun mergeSortedArrayTest() {
        var nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        var numsSize1 = 3
        var nums2 = intArrayOf(2, 5, 6)
        var numsSize2 = 3
        merge(nums1, numsSize1, nums2, numsSize2)
        assertContentEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)

        nums1 = intArrayOf(1)
        numsSize1 = 1
        nums2 = intArrayOf()
        numsSize2 = 0
        merge(nums1, numsSize1, nums2, numsSize2)
        assertContentEquals(intArrayOf(1), nums1)

        nums1 = intArrayOf(1, 0)
        numsSize1 = 1
        nums2 = intArrayOf(0)
        numsSize2 = 1
        merge(nums1, numsSize1, nums2, numsSize2)
        assertContentEquals(intArrayOf(0, 1), nums1)
    }
}