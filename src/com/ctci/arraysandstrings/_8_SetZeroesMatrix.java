package com.ctci.arraysandstrings;

public class _8_SetZeroesMatrix {

    /**
     * Set Zeroes Matrix
     * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
     * You must do it in place.
     *
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     */

    /**
     * Though Process
     * Approach #2: Recommended
     * use first position of each row / column to indicate that the corresponding row / column has a zero given. (Use first row and first column as indicators of zeroes)
     * But for first row and first column - the position is same for both - matrix[0][0].
     * That's why we need an additional variable to differente whether it is row / column.
     * isCol = false is the new variable
     * T.C = O(m.n), S.C = O(1)
     */


    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        // without additonal memory - O(1)
        // use first position in each row and column as the indicators for zeros.
        // but for first row and forst column - positions are same so use "isCol" variable.

        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                isCol = true;
            }

            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // iterate from second row, second column and check for zeroes
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // check for first row
        if(matrix[0][0] == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // check for first column
        if(isCol){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
