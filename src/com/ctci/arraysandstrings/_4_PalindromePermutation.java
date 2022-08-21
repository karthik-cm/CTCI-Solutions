package com.ctci.arraysandstrings;

import java.util.HashMap;

public class _4_PalindromePermutation {

    /**
     * Given a string s, return true if a permutation of the string could form a palindrome.
     * Input: s = "code"
     * Output: false
     *
     * Input: s = "aab"
     * Output: true
     */


    /**
     * Thought Process:
     * For a String of even length to be a Palindrome - all the characters in that String should be of even length only. No odd length characters.
     * For a String of odd length to be a Palindrome - there can be only one char only which has odd length which occurs in the middle of the string
     * and rest all with even length characters.
     */

    public static void main(String[] args) {
        String s = "rraceca";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        // take a hashmap and count the occurrences of characters: ["a": "1", "b": 2]...
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // iterate the map and check like at-most only one odd occurrence of the character should be present
        int count = 0;
        for(char key : map.keySet()){
            int value = map.get(key);

            if(value % 2 == 1) count++;

            if(count > 1) return false;
        }

        return count <= 1;
    }

}
