package com.ctci.linkedlists;

public class _2_ReturnKthToLast {

    /**
     * Return Kth to Last:
     * Implement an algorithm to find the kth to last element of a singly linked list.
     *
     * Input: [1,2,3,4,5], k=2
     * Output: [4]
     */

    ListNode findKthTolast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        /* Move p1 k nodes into the list.*/
        for (int i= 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end, p2 will be at the right element. */
        while (p1!= null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
