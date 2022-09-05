package com.ctci.linkedlists;

public class _3_DeleteNode {

    /**
     * Delete Node:
     * Implement an algorithm to delete a node in the middle
     * (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
     * given only access to that node.
     *
     * EXAMPLE
     * Input: the node c from the linked list a->b->c->d->e->f
     * Result: nothing is returned, but the new linked list looks like a ->b->d->e->f
     *
     * LeetCode #237
     * /

     /**
     * Thought Process:
     * In this problem, you are not given access to the head of the linked list. You only have access to that node.
     * The solution is simply to copy the data from the next node over to the current node, and then to delete the
     * next node.
     * Note that this problem cannot be solved if the node to be deleted is the last node in the linked list.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
