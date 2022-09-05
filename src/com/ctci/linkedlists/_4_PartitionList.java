package com.ctci.linkedlists;

public class _4_PartitionList {

    /**
     * Partition List:
     * Write code to partition a linked list around a value x,
     * such that all nodes less than x come before all nodes greater than or equal to x.
     * If x is contained within the list the values of x only need to be after the elements less than x (see below).
     * The partition element x can appear anywhere in the "right partition";
     * it does not need to appear between the left and right partitions.
     *
     * EXAMPLE
     * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
     * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     *
     * LeetCode #86
     */

    /**
     * Thought Process:
     * create 2 reference nodes with the starting head along with 2 pointers to each of them respectively.
     * Next iterate the given linked list from head by checking the value.
     * if value is < x, then add it to lessThan list
     * else add it to greaterThan list.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */


    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode lessThan = new ListNode(0);
        ListNode less = lessThan;
        ListNode greaterThan = new ListNode(0);
        ListNode greater = greaterThan;

        // If the original list node is lesser than the given x,
        // assign it to the before list.
        ListNode node = head;
        while(node != null){
            if(node.val < x){
                less.next = node;
                less = less.next;
            }
            else{
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                greater.next = node;
                greater = greater.next;
            }

            node = node.next;
        }

        // end of list should point to null
        greater.next = null;

        // join the lessThan and greaterThan lists
        less.next = greaterThan.next;

        return lessThan.next;
    }
}
