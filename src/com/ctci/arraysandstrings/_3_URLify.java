package com.ctci.arraysandstrings;

import java.util.Arrays;

public class _3_URLify {

    /**
     * URLify: Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
     * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
     * EXAMPLE
     * Input: "Mr John Smith", 13
     * Output: "Mr%20John%20Smith"
     */

    public static void main(String[] args) {
        String str = "Mr John Smith";
        int totalLength = 13;

        System.out.println(urlify(str, totalLength));
    }


    public static String urlify(String str, int totalLength){
        int whitespaceCount = 0;
        for(char c : str.toCharArray()){
            if(c == ' '){
                whitespaceCount++;
            }
        }

        // now all the whitespaces has to be replaced with %20
        char[] newStr = new char[totalLength + whitespaceCount*2];
        int index = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == ' '){
                newStr[index] = '%';
                newStr[index + 1] = '2';
                newStr[index + 2] = '0';
                index = index + 3;
            }
            else{
                newStr[index] = c;
                index = index + 1;
            }
        }

        System.out.println(Arrays.toString(newStr));

        return new String(newStr);
    }

}
