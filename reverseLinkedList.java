Class Solution{
    /* input: 1->2->3->4->null
    output: 4->3->2->1->null
    */
    public ListNode ReverseLinkedList(ListNode head){
        ListNode result = null;
        while(head != null){
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}