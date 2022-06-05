class Solution {
    // Time: O(N)
    // Space: O(N)
    public int lengthOfLIS(int[] nums) {
        /* DP represents length of longest increasing subsequence ending at i
            base case: dp[0] = 1
            dp[i] represents the length of the longest ascending subsequence ending at i 
            LOOK AT MULTIPLE VALUES (Compare i to all values before and select highest value)
            COMPARE DPs AT VALUES
        */
        int[] dp = new int[nums.length];
        dp[0] = 1;
       
        // Determine longest sub
        for(int i = 1; i < nums.length; i++){
            // Determine maximum dp to add
            int maxDP = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    maxDP = Math.max(dp[j], maxDP);
                }
            }
            // Add max DP to DP[i]
            dp[i] = 1 + maxDP;
        }
        
        // Linear scan to find longest increasing subsequence
        int maxSub = 0;
        for(int i = 0; i < dp.length; i++){
            maxSub = Math.max(maxSub, dp[i]);
        }
        return maxSub;
    }
}
