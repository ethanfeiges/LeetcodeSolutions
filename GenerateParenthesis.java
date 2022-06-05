class Solution {
    // DFS solution for Leetcode #22
    // Time: O(2^N)
    // Space: O(2^N)
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> combos = new ArrayList();
        helper(n, 0, 0, combos, sb);
        return combos;
    }
    
    public void helper(int n, int l, int r, List<String> combos, StringBuilder sb){
        
        // If there are a maximum number of "("
        if(l == n){
            // Continue adding ")" to supplement
            for(int i = r; i < n; i++){
                sb.append(")");  
            }
            combos.add(new String(sb.toString()));
            return;
        }
        // Rule: There always needs to be a "(" before a ")"
        else if(l == r){
            sb.append("(");
            l++;
            // If at the limit
            if(l == n){
                sb.append(")");
                combos.add(sb.toString());
                return;
            }
        }
        // create new copies of sb to avoid reference semantics
        sb.append("(");
        helper(n, l + 1, r, combos, new StringBuilder(sb));
        // Delete the last added ")"
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        helper(n, l, r + 1, combos, new StringBuilder(sb));     
    }
}
