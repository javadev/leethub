/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(num: IntArray): TreeNode? {
        /*1. Set up recursion*/
        return makeTree(num, 0, num.size - 1)
    }

    private fun makeTree(num: IntArray, left: Int, right: Int): TreeNode? {
        /*2. left as lowest# can't be greater than right*/
        if (left > right) {
            return null
        }
        /*3. Set median# as node*/
        val mid = (left + right) / 2
        val midNode = TreeNode(num[mid])
        /*4. Set mid node's kids*/
        midNode.left = makeTree(num, left, mid - 1)
        midNode.right = makeTree(num, mid + 1, right)
        /*5. Sends node back || Goes back to prev node*/
        return midNode
    }
}
