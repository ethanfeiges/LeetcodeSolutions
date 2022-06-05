
// Dynamic Programming solution for Leetcode #5
class Solution {
    // Time: O(N^2)
    // Space: O(N^2)
    public String longestPalindrome(String s) {
    String r = "";
    // DP represents whether the substring partitioned at index i and index j make a palindrome
    boolean[][] dp = new boolean[s.length()][s.length()];
    for(int i = s.length() - 1; i >= 0; i--){
        for(int j = i; j < s.length(); j++){
            if(j - i + 1 < 3){
                dp[i][j] = s.charAt(i) == s.charAt(j);
            }else{
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = false;
                    }
                }
                if(dp[i][j] && j - i + 1 > r.length()){
                    r = s.substring(i, j + 1);
                }
            }
        }
        return r;
    }
        
    }
