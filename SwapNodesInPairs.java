/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Solution to LeetCode #24
// Time: O(N)
// Space: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        // Initial values
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode nextNode = head.next;
        
        while(nextNode != null){
            // Swap in pairs:
            // FIRST ITERATION:
            // 1-2-3-4 -> 2-1-3-4
            prev.next = nextNode;
            ListNode temp = nextNode.next;
            nextNode.next = cur;
            cur.next = temp;
             
            
            // Linked list is odd (no more switches to be made)
            if(temp == null){
                return dummy.next;
            }
            // move along linked list
            prev = cur;
            cur = temp;
            nextNode = temp.next;
            
        }
        // Dummy points to the head of the swapped linked list
        return dummy.next;
        
    }
}
