class Solution {
2
    // Dynamic programming to solve Leetcode #120
3
    // Time: O(N)
4
    // Space: O(N)
5
    public int minimumTotal(List<List<Integer>> triangle) {
6
        // dp represents the minimum path sum to each point in the triangle
7
        List<List<Integer>> dp = new ArrayList();
8
        // base case triangle.get(0).get(0)
9
        List<Integer> base = new ArrayList();
10
        base.add(triangle.get(0).get(0));
11
        dp.add(base);
12
        for(int i = 1; i < triangle.size(); i++){
          
13          // Holds all DP values of a single level in a triangle
            List<Integer> level = new ArrayList();
14
            for(int j = 0; j < triangle.get(i).size(); j++){
15
                // edge cases
16
                // if at the left most number in triangle row
17
                if(j == 0){
18
                    level.add(triangle.get(i).get(j) + dp.get(i - 1).get(j));
19
                }
20
                // if at right most number in triangle row
21
                else if(j == triangle.get(i).size() - 1){
22
                    level.add(triangle.get(i).get(j) + dp.get(i - 1).get(j - 1));
23
                }
24
                else{
25
                    // finding minimum path sum to number at [i, j]
26
                    level.add(triangle.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
27
                }
28
                
29
            }
30          // Adds level to entire DP nested list
            dp.add(level);
31
        }
32
        return Collections.min(dp.get(triangle.size() - 1));
33
    }
34
}
