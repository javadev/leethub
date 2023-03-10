class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return ArrayList()
        val letters = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val ans: MutableList<String> = ArrayList()
        val sb = StringBuilder()
        findCombinations(0, digits, letters, sb, ans)
        return ans
    }

    private fun findCombinations(
        start: Int,
        nums: String,
        letters: Array<String>,
        curr: StringBuilder,
        ans: MutableList<String>
    ) {
        if (curr.length == nums.length) {
            ans.add(curr.toString())
            return
        }
        for (i in start until nums.length) {
            val n = Character.getNumericValue(nums[i])
            for (j in 0 until letters[n].length) {
                val ch = letters[n][j]
                curr.append(ch)
                findCombinations(i + 1, nums, letters, curr, ans)
                curr.deleteCharAt(curr.length - 1)
            }
        }
    }
}
