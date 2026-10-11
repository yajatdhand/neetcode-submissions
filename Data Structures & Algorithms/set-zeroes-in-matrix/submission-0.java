class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        //populate rows
        for(int i = 0; i < m; ++i){
            if(rows[i] == 1){
                for(int j = 0; j < n; ++j) matrix[i][j] = 0;
            }
        }

        //populate cols
        for(int j = 0; j < n; ++j){
            if(cols[j] == 1){
                for(int i = 0; i < m; ++i) matrix[i][j] = 0;
            }
        }
    }
}
