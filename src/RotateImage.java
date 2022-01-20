//Problem Statement : https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n,i;
        int k = 0;
        int temp;
        while(k<matrix.length-1){
            n = matrix.length-1-2*k;
            i = 0;
            while(i<n){
                swap(matrix,n+k,i+k,n-i+k,n+k);

                // temp = matrix[n+k][i+k];
                // matrix[n+k][i+k] = matrix[n-i+k][n+k];
                // matrix[n-i+k][n+k] = temp;

                i++;
            }
            i = n;
            while(i>0){
                swap(matrix,i+k,n+k,0+k,i+k);

                // temp = matrix[i+k][n+k];
                // matrix[i+k][n+k] = matrix[0+k][i+k];
                // matrix[0+k][i+k] = temp;

                i--;
            }
            i = n;
            while(i>0){
                swap(matrix,0+k,i+k,n-i+k,0+k);

                // temp = matrix[0+k][i+k];
                // matrix[0+k][i+k] = matrix[n-i+k][0+k];
                // matrix[n-i+k][0+k] = temp;

                i--;
            }
            k++;
        }

    }
    public void swap(int[][] matrix,int r1,int c1,int r2,int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
