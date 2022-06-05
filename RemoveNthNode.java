// Solution for Leetcode #19
// Time: O(N)
// Space: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = dummy;
        
        ListNode run = head;
        // Represents total amount of nodes in linked list
        int total = 1;
        // keeps track of the "index" of the node
        while(run != null){
            run = run.next;
            total++;
            
        }
        
        int count = 1;
        // Keep on traversing through linked list until you reach the nth node from the end
        while(count != total - n){
            prev = cur;
            cur = cur.next;
            count++;
        }
        // Cut off the nth node from the end of the linked list:
        prev.next = cur.next;
        return dummy.next;
    }
}
