class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val sb = StringBuilder()
        val ans: MutableList<String> = ArrayList()
        return generate(sb, ans, n, n)
    }

    private fun generate(sb: StringBuilder, str: MutableList<String>, open: Int, close: Int): List<String> {
        if (open == 0 && close == 0) {
            str.add(sb.toString())
            return str
        }
        if (open > 0) {
            sb.append('(')
            generate(sb, str, open - 1, close)
            sb.deleteCharAt(sb.length - 1)
        }
        if (close > 0 && open < close) {
            sb.append(')')
            generate(sb, str, open, close - 1)
            sb.deleteCharAt(sb.length - 1)
        }
        return str
    }
}
