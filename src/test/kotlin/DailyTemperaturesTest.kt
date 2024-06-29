import kotlin.test.Test
import kotlin.test.assertContentEquals

object DailyTemperaturesTest {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size) { 0 }
        var i = temperatures.size - 1
        for (t in temperatures.reversed()) {
            var counter = 0
            while (!stack.isEmpty()) {
                val last = stack.last()
                if (last < t && stack.size == 1) {
                    result[i] = 0
                    stack.removeLast()
                } else if (last > t) {
                    result[i] = counter
                    break
                } else {
                    counter++
                    stack.removeLast()
                }
            }
            i--
            stack.addLast(t)
        }
        return result
    }

    @Test
    fun testDailyTemperatures() {
        val test1 = intArrayOf(30, 60, 90)
        val result1 = dailyTemperatures(test1)
        assertContentEquals(intArrayOf(1, 1, 0), result1)

        val test2 = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val result2 = dailyTemperatures(test2)
        assertContentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0), result2)
    }
}