import java.util.ArrayDeque
import java.util.Deque

class Solution {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val stack: Deque<Log> = ArrayDeque()
        val result = IntArray(n)
        for (content in logs) {
            val log = Log(content)
            if (log.isStart) {
                stack.push(log)
            } else {
                val top = stack.pop()
                val executionTime = log.time - top.time + 1
                result[top.id] += executionTime - top.waitingTime
                if (!stack.isEmpty()) {
                    stack.peek().waitingTime += executionTime
                }
            }
        }
        return result
    }

    private class Log internal constructor(content: String) {
        var id: Int
        var isStart: Boolean
        var time: Int
        var waitingTime: Int
        init {
            val tokens = content.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            id = tokens[0].toInt()
            isStart = tokens[1] == "start"
            time = tokens[2].toInt()
            waitingTime = 0
        }
    }
}
