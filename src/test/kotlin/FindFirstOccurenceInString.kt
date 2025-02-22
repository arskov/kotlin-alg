import kotlin.test.Test
import kotlin.test.assertEquals

fun String.chash(): Long {
    return this.fold(0L) { acc, ch -> acc + ch.code }
}

object FindFirstOccurenceInString {

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val hsz = haystack.length
        val nsz = needle.length
        if (nsz > hsz) return -1
        val nhash = needle.chash()
        var rhash = haystack.substring(0, nsz).chash()
        if (nhash == rhash && needle == haystack.substring(0, nsz))
            return 0
        for (i in 1..(hsz - nsz)) {
            rhash -= haystack[i - 1].code
            rhash += haystack[i + nsz - 1].code
            if (nhash == rhash && needle == haystack.substring(i, i + nsz))
                return i
        }
        return -1
    }
}

@Test
fun testFirstOccurenceInString {
    val solution = Solution()
    assertEquals(-1, solution.strStr("leetcode", "letco")
    assertEquals(3, solution.strStr("leetcode", "tc")
}

}
