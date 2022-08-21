package com.ctci.arraysandstrings;

public class _6_StringCompression {

    /**
     * String Compression: Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
     * "compressed" string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     *
     * ex: Input = aabcccccaaa, Output = a2blc5a3
     */

    public static void main(String[] args) {
        //String input = "aabcccccaaa";
        String input = "aaaaaabbbbcdddddmmmsssskkkkk";

        System.out.println(compress(input));
    }

    public static String compress(String input){
        if(input == null || input.length() == 0){
            return null;
        }

        int len = input.length();
        int counter = 0;
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < len - 1; i++){
            char curr = input.charAt(i);
            char next = input.charAt(i + 1);
            counter++;

            if(curr != next){
                output.append(curr);
                output.append(counter);
                counter = 0;
            }
        }

        output.append(input.charAt(len - 1));
        output.append(counter + 1);

        return output.length() > len ? input : output.toString();
    }

}
