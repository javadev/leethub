class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>?): Int {
        if (grid.isNullOrEmpty()) {
            return 0
        }
        val m = grid.size
        val n = grid[0].size
        var max = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    val area = dfs(grid, i, j, m, n, 0)
                    max = Math.max(area, max)
                }
            }
        }
        return max
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int, m: Int, n: Int, area: Int): Int {
        var area = area
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return area
        }
        grid[i][j] = 0
        area++
        area = dfs(grid, i + 1, j, m, n, area)
        area = dfs(grid, i, j + 1, m, n, area)
        area = dfs(grid, i - 1, j, m, n, area)
        area = dfs(grid, i, j - 1, m, n, area)
        return area
    }
}
