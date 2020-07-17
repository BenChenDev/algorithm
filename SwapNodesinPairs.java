/*Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.


Note: the key point of doing this question is understanding the structure of a linked list data structure 
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
  public ListNode swapPairs(ListNode head) {
      
      
      if(head == null || head.next == null){
          return head;
      }
      
      ListNode first = head, second = first.next, previous = new ListNode();
      ListNode result = second;
      
      while(first != null && second!= null){
          //swap
          first.next = second.next;
          second.next = first;
          
          if(previous != null){
              previous.next = second;
          }
          previous = first;
          
          //move pointers
          first = first.next;
          if(first == null){
              return result;
          }else{
              second = first.next;
              if(second == null){
                  return result;
              }
          }
      }
      
      return result;
  }

  //recursively
    
  if(head == nul || head.next == null){
    return head;
  }

  ListNode nxt = head.next;
  head.next = swapPairs(nxt.next);
  nxt.next = head;

  return nxt;

}