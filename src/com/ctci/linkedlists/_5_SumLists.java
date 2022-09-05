package com.ctci.linkedlists;

public class _5_SumLists {

    /**
     * Sum Lists:
     * You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * EXAMPLE
     * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
     *
     * LeetCode #2
     */

    /**
     * Thought Process:
     * Given 2 Linked Lists, we have to sum up the values from it and create a new List.
     * Start from the head of both the lists l1 and l2, maintain a variable for "carry" purpose.
     * if node is null, take as zero else take appropriate value.
     * carry = sum / 10; new_list.next = new LinkedList(sum % 10)
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        return head.next;
    }
}
