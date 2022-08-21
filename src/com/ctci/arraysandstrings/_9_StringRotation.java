package com.ctci.arraysandstrings;

public class _9_StringRotation {

    /**
     * String Rotation:
     * Assume you have a method isSubString which checks if one word is a substring of another.
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
     * call to isSubString
     * (e.g., "waterbottle" is a rotation of "erbottlewat")
     */

    /**
     * to check if rotation of s2 is a substring of s1 using only one call to isSybString()
     */

    public static void main(String[] args) {

    }


    public static boolean isRotation(String s1, String s2){
        if(s1.length() > 0 && s2.length() > 0 && s1.length() == s2.length()){
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }

        return false;
    }

    public static boolean isSubString(String s1, String s2){
        // TODO: to be implemented
        return true;
    }

}
