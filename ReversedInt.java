// Solution to Leetcode #7 Reversed Integer
// Time: O(digits);
// Space: O(1)

class Solution {
    public int reverse(int x) {
        int reversed = 0;
        double checker  = 0;
        boolean isNeg = false;
        if(x < 0){
           isNeg = true;
        }
       
        x = Math.abs(x);
        int prev = 0;
    
        while(x > 0){
          int digit = x % 10; 
          reversed = reversed * 10 + digit;
          checker = checker * 10 + digit;
          // checks if reversed number has exceeded integer capacity
          if(checker >= Math.pow(2, 31)){
              return 0;
          }
          x /= 10;
        }
        
        
        return isNeg?reversed * -1:reversed;
    }
}