class Solution {
    fun longestPalindrome(s: String): String {
        val newStr = CharArray(s.length * 2 + 1)
        newStr[0] = '#'
        for (i in s.indices) {
            newStr[2 * i + 1] = s[i]
            newStr[2 * i + 2] = '#'
        }
        val dp = IntArray(newStr.size)
        var friendCenter = 0
        var friendRadius = 0
        var lpsCenter = 0
        var lpsRadius = 0
        for (i in newStr.indices) {
            dp[i] = if (friendCenter + friendRadius > i) Math.min(
                dp[friendCenter * 2 - i],
                friendCenter + friendRadius - i
            ) else 1
            while (i + dp[i] < newStr.size && i - dp[i] >= 0 && newStr[i + dp[i]] == newStr[i - dp[i]]) {
                dp[i]++
            }
            if (friendCenter + friendRadius < i + dp[i]) {
                friendCenter = i
                friendRadius = dp[i]
            }
            if (lpsRadius < dp[i]) {
                lpsCenter = i
                lpsRadius = dp[i]
            }
        }
        return s.substring((lpsCenter - lpsRadius + 1) / 2, (lpsCenter + lpsRadius - 1) / 2)
    }
}
