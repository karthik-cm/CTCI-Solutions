package com.ctci.linkedlists;

public class _7_IntersectionOfTwoLists {

    /**
     * Intersection:
     * Given two (singly) linked lists, determine if the two lists intersect.
     * Return the intersecting node. Note that the intersection is defined based on reference, not value.
     * That is, if the kth node of the first linked list is the exact same node (by reference)
     * as the jth node of the second linked list, then they are intersecting
     *
     * Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
     * Output: ListNode Intersected at '8'
     *
     * LeetCode #160
     */

    /**
     * Note: return should be Intersection of ListNode by reference not value:
     *
     * Approach #1: Hash Table:
     * Add the nodes from headA into the HashSet. Then check if any node is present in set by iterating from headB.
     * Time Complexity = O(M) + O(N)
     * Space Complexity = O(M)
     *
     * Approach #2: Recommended:
     * 1. Run through each linked list to get the lengths
     * 2. Set two pointers to the start of each linked list
     * 3. On the longer linked list, advance its pointer by the difference in lengths
     * 4. Now, traverse on each linked list until the pointers are the same (reference not value)
     * Time Complexity = O(M + N)
     * Space Complexity = O(1)
     */


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Approach #2:
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0, lenB = 0;

        while(tempA != null){
            lenA++;
            tempA = tempA.next;
        }

        while(tempB != null){
            lenB++;
            tempB = tempB.next;
        }

        if(lenA >= lenB){
            // advance the headA pointer by (lenA - lenB) times
            tempA = headA;
            for(int i = 0; i < (lenA - lenB); i++){
                tempA = tempA.next;
            }

            tempB = headB;

            while(tempA != null && tempB != null){
                if(tempA == tempB){
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }

            return null;
        }
        else{
            return getIntersectionNode(headB, headA);
        }

    }
}
