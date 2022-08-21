package com.ctci.arraysandstrings;

public class _1_IsUnique {

    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures ?
     */

    /**
     * The given String can be of ASCII type or Unicode.
     * ASCII is the subset with 128 characters (a-z A-Z 0-9 symbols).
     *
     */

    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "aabcd";

        System.out.println(str +" = "+isUnique(str));
        System.out.println(str2 +" = "+isUnique(str2));
    }

    // Time Complexity = O(n) / O(128), Space Complexity = O(1)
    public static boolean isUnique(String str){
        // assuming the String as ASCII String which has 128 chars
        if(str.length() > 128){
            return false;
        }

        boolean[] char_sets = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_sets[val]){
                return false;
            }

            char_sets[val] = true;
        }

        return true;
    }

}
