package com.ctci.linkedlists;

import java.util.LinkedHashMap;
import java.util.Map;

public class _1_RemoveDuplicates {

    /**
     * Remove Duplicates fom an unsorted Linked List
     * Write code to remove duplicates from an unsorted linked list.
     * Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
     * Return the linked list after the deletions.
     *
     * Input: head = [1,2,3,2]
     * Output: [1,3]
     *
     * LeetCode: #1836
     */

    /**
     * Thought Process:
     * count the occurrences of the elements and store it in the map.
     * like map[value1: count1, value2: count2 ...]
     *
     * then start iterating the map and check the count
     * if count <= 1 start adding them into a new list
     * else if count is greater than one - discard.
     * and return new head
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        ListNode node = head;
        while(node != null){
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode dummy = sentinel;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value <= 1){
                dummy.next = new ListNode(key);
                dummy = dummy.next;
            }
        }

        return sentinel.next;
    }

}
