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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result; //pointer points to the head of the result listNode
        
        boolean l1Finish = false;
        boolean l2Finish = false;
        
        int remainder = 0;
        int ans = 0;
        while(!l1Finish || !l2Finish || remainder != 0){
            ans = (!l1Finish ? l1.val : 0) 
                + (!l2Finish ? l2.val : 0) 
                + remainder;
            
            result.next = new ListNode(ans%10);
            result = result.next;
            
            remainder = ans/10;
            
            if(l1.next != null){ 
                l1 = l1.next;
            }else{
                l1Finish = true; 
            }
            
            if(l2.next != null){ 
                l2 = l2.next;
            }else{
                l2Finish = true; 
            }
        }
        
        return pointer.next;
    }
}