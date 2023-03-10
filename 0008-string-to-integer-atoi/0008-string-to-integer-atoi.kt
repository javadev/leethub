class Solution {
    fun myAtoi(str: String?): Int {
        if (str.isNullOrEmpty()) {
            return 0
        }
        var i = 0
        var negativeSign = false
        val input = str.toCharArray()
        while (i < input.size && input[i] == ' ') {
            i++
        }
        if (i == input.size) {
            return 0
        } else if (input[i] == '+') {
            i++
        } else if (input[i] == '-') {
            i++
            negativeSign = true
        }
        var num = 0
        while (i < input.size && input[i] <= '9' && input[i] >= '0') {
            // current char
            var tem = input[i] - '0'
            tem = if (negativeSign) -tem else tem
            // avoid invalid number like 038
            if (num == 0 && tem == '0'.toInt()) {
                i++
            } else if (num == Int.MIN_VALUE / 10 && tem <= -8 || num < Int.MIN_VALUE / 10) {
                return Int.MIN_VALUE
            } else if (num == Int.MAX_VALUE / 10 && tem >= 7 || num > Int.MAX_VALUE / 10) {
                return Int.MAX_VALUE
            } else {
                num = num * 10 + tem
                i++
            }
        }
        return num
    }
}
