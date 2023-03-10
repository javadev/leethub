/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) {
            return head
        }
        var tail = head
        // find the count and let tail points to last node
        var count = 1
        while (tail != null && tail.next != null) {
            count++
            tail = tail.next
        }
        // calculate number of times to rotate by count modulas
        val times = k % count
        if (times == 0) {
            return head
        }
        var temp = head
        // iterate and go to the K+1 th node from the end or count - K - 1 node from
        // start
        var i = 1
        while (i <= count - times - 1 && temp != null) {
            temp = temp.next
            i++
        }
        var newHead: ListNode? = null
        if (temp != null && tail != null) {
            newHead = temp.next
            temp.next = null
            tail.next = head
        }
        return newHead
    }
}
