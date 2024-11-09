import kotlin.test.Test
import kotlin.test.assertEquals

object BuyAndSellStocks2 {

    class Solution {
        fun maxProfit(prices: IntArray): Int {
            if (prices.size < 2) return 0
            var maxProfit = 0
            var tmpMax = 0
            var j = 0
            for (i in 1..<prices.size) {
                if (prices[i] >= prices[i - 1]) {
                    tmpMax = prices[i] - prices[j]
                } else {
                    j = i
                    maxProfit += tmpMax
                    tmpMax = 0
                }

            }
            return maxProfit + tmpMax
        }
    }

    @Test
    fun testMaxProfit() {
        val solution = Solution()
        assertEquals(7, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(4, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}