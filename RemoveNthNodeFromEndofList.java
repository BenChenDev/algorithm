/**Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5. 
*/
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
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode slow = head, fast = head;
      while(n-- > 0){
          fast = fast.next;
      }
      
      if(fast == null){
          return head.next;
      }
      
      while(fast.next != null){
          slow = slow.next;
          fast = fast.next;
      }
      
      slow.next = slow.next.next;
      
      return head;
  }
}