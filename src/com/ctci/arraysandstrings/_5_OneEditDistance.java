package com.ctci.arraysandstrings;

public class _5_OneEditDistance {

    /**
     * One Away / One Edit Distance
     *
     * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
     *
     * A string s is said to be one distance apart from a string t if you can:
     *
     * Insert exactly one character into s to get t.
     * Delete exactly one character from s to get t.
     * Replace exactly one character of s with a different character to get t.
     */

    public static void main(String[] args) {
        String s = "ba";
        String t = "abc";

        System.out.println(isOneEditDistance(s, t));
    }

    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            // more than 1 edit distance apart
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }

        // if both traversed till the end of strings. so s equals t which is not acceptable.
        if (i == m && j == n) {
            return false;
        }

        System.out.println("i = "+i +", j = "+j);

        if (m > n) {
            // deletion is only possible
            System.out.println("if");
            System.out.println("s = "+s.substring(i + 1));
            System.out.println("t = "+t.substring(j));
            return s.substring(i + 1).equals(t.substring(j));
        }
        else if (m < n) {
            // insertion is only possible
            System.out.println("else if");
            System.out.println(s.substring(i));
            System.out.println(t.substring(j + 1));
            return s.substring(i).equals(t.substring(j + 1));
        }
        else {
            // replacing is only possible
            System.out.println("else");
            return s.substring(i + 1).equals(t.substring(j + 1));
        }
    }
}
