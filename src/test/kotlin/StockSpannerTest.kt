import kotlin.test.Test
import kotlin.test.assertContentEquals

object StockSpannerTest {
    class StockSpanner() {

        private val stack = ArrayDeque<Pair<Int, Int>>()
        private var day = 0

        fun next(price: Int): Int {
            while (stack.isNotEmpty() && price >= stack.last().second) {
                stack.removeLast()
            }
            val res = if (stack.isNotEmpty()) {
                day - stack.last().first
            } else {
                day + 1
            }
            stack.addLast(Pair(day, price))
            day += 1
            return res
        }

    }

    @Test
    fun testStockSpanner() {
        var spanner = StockSpanner()
        val stocks1 = intArrayOf(100, 80, 60, 70, 60, 75, 85)
        val res1 = stocks1.map { spanner.next(it) }.toIntArray()
        val expected1 = intArrayOf(1, 1, 1, 2, 1, 4, 6)
        assertContentEquals(expected1, res1)

        spanner = StockSpanner()
        val stocks2 = intArrayOf(31, 41, 48, 59, 79)
        val res2 = stocks2.map { spanner.next(it) }.toIntArray()
        val expected2 = intArrayOf(1, 2, 3, 4, 5)
        assertContentEquals(expected2, res2)

        spanner = StockSpanner()
        val stocks3 = intArrayOf(1, 2, 3, 4, 5)
        val res3 = stocks3.map { spanner.next(it) }.toIntArray()
        val expected3 = intArrayOf(1, 2, 3, 4, 5)
        assertContentEquals(expected3, res3)

        spanner = StockSpanner()
        val stocks4 = intArrayOf(5, 4, 3, 2, 1)
        val res4 = stocks4.map { spanner.next(it) }.toIntArray()
        val expected4 = intArrayOf(1, 1, 1, 1, 1)
        assertContentEquals(expected4, res4)
    }
}