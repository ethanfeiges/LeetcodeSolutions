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
// Time: O(N)
// Space: O(1)
class Solution {
    // Insertion sort: Sorts subsets of a larger linked list
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        // Can skip first node in the linked list
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            // continue if subset of linked list is already in order
            // No sorting needs to be done in this instance
            if(cur.val >= prev.val){
                prev = cur;
                cur = cur.next;
                continue;
            }
            // Start at the beginning of linked list (dummy) if sorting needs to be done
            ListNode temp = dummy;
            // Continue to advance until you can find a spot
            while(cur.val > temp.next.val){
                temp = temp.next;
            }
            // Swapping once a place is found
            // Inserting cur in between temp and prev
            prev.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            // Advance current pointer
            cur = prev.next;  
        }
        // dummy.next points to head
        return dummy.next;
    }
}
