import kotlin.test.Test
import kotlin.test.assertEquals

object OverlappingIntervalsTest {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith { a, b ->
            a[1] - b[1]
        }
        var counter = 0
        var current: Int? = null
        for (interval in intervals) {
            if (current != null) {
                when {
                    interval[0] < current -> counter++
                    else -> current = interval[1]
                }
            } else {
                current = interval[1]
            }
        }
        return counter
    }

    @Test
    fun testOverlappingIntervals() {
        val sample1 = arrayOf(
            intArrayOf(1, 100),
            intArrayOf(11, 22),
            intArrayOf(1, 11),
            intArrayOf(2, 12)
        )
        val res1 = eraseOverlapIntervals(sample1)
        assertEquals(2, res1)

        val sample2 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
        )
        val res2 = eraseOverlapIntervals(sample2)
        assertEquals(2, res2)
    }
}

