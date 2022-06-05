// Uses dynamic programming to solve leetcode #64
class Solution {
    // Time O[m * n]
    // Space: O[m * n]
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // DP 2D array Represents most optimal path (least sum) to each element in the grid
        int[][] dp = new int[m][n];
        for(int i  = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    // base case
                    dp[i][j] = grid[0][0];
                }
                // If in first column
                else if(i == Math.max(i - 1, 0)){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
                // If in first row
                else if(j == Math.max(j - 1, 0)){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[Math.max(i - 1, 0)][j], dp[i][Math.max(j - 1, 0)]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
