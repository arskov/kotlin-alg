import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

object MinimumNumberOfArrowsTest {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var count = 1
        points.sortWith { a, b ->
            when {
                a[0] < b[0] -> -1
                a[0] > b[0] -> 1
                else -> when {
                    a[1] < b[1] -> -1
                    a[1] > b[1] -> 1
                    else -> 0
                }
            }
        }
        var last = points[0][1]
        for (point in points.drop(1)) {
            if (point[0] > last) {
                last = point[1]
                count++
            } else {
                last = minOf(point[1], last)
            }
        }
        return count
    }

    @Test
    fun testMinimumNumberOfArrows() {
        val test1 = arrayOf(
            intArrayOf(10,16),
            intArrayOf(2,8),
            intArrayOf(1,6),
            intArrayOf(7,12),
        )
        val res1 = findMinArrowShots(test1)
        assertEquals(2, res1)

        val test2 = arrayOf(
            intArrayOf(1,2),
            intArrayOf(3,4),
            intArrayOf(5,6),
            intArrayOf(7,8),
        )
        val res2 = findMinArrowShots(test2)
        assertEquals(4, res2)
    }
}