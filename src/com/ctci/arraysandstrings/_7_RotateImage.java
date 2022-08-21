package com.ctci.arraysandstrings;

public class _7_RotateImage {

    /**
     * Rotate Image - #48
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     */

    /**
     * Thought Process:
     * The most elegant solution for rotating the matrix is to firstly reverse the matrix around the main diagonal,
     * and then reverse it from left to right. These operations are called transpose and reflect in linear algebra.
     */


    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length){
            return;
        }

        transpose(matrix);
        reflect(matrix);
    }


    public void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reflect(int[][] matrix){
        for(int[] row : matrix){
            int i = 0;
            int j = row.length - 1;

            while(i <= j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;

                i++;
                j--;
            }
        }
    }

}
