package com.ctci.arraysandstrings;

import java.util.Arrays;

public class _2_CheckPermutations {

    /**
     * Check Permutations: Given two Strings, write a method to decide if one is a permutation of the other.
     */


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bac";

        System.out.println("s1 = "+s1 +", s2 = "+s2 +": are permutations = "+arePermutations(s1, s2));
        System.out.println("s1 = "+s1 +", s2 = "+s2 +": are permutations = "+arePermutations2(s1, s2));
    }


    // Solution #1 - sort the strings and compare them
    public static boolean arePermutations(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }



    // Solution #2 - Check if 2 String have identical character rounds
    public static boolean arePermutations2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[128]; // assuming String as ASCII String
        for(char c : s1.toCharArray()){
            letters[c]++;
        }

        for(int i = 0; i < s2.length(); i++){
            char c  = s2.charAt(i);
            letters[(int) c]--;

            if(letters[(int) c] < 0){
                return false;
            }
        }

        return true;
    }
}
