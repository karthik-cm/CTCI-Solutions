package com.ctci.linkedlists;

public class _6_PalindromeList {

    /**
     * Palindrome Linked List:
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     *
     * Input: head = [1,2,2,1]
     * Output: true
     *
     * LeetCode #234
     */

    /**
     * First Approach:
     * use arraylist to store the elements are verify if the arraylist is an Palindrome using two-pointer technique.
     * Time Complexity = O(N)
     * Space Complexity = O(N)
     *
     * Second Approach (Recommended):
     * first place a pointer to the middle of the list OR firstHalfEnd
     * then reverse the given list from firstHalfEnd.next
     * now, take head as pointer1 and secondHalfStart as pointer2 and compare the elements if not same, return false;
     * once done, again reverse the list from secondHalfStart so that the original list stays unaltered.
     *
     * Time Complexity = O(N)
     * Space Complexity = O(1)
     */



    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        // find end of first half and using that reverse the second half
        ListNode firstHalfEnd = findFirstHalfEnd(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // use two pointers to compare the list and determine palindrome property
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while(p2 != null){
            if(p1.val != p2.val){
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // restore the list
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        return prev;
    }

    public ListNode findFirstHalfEnd(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
