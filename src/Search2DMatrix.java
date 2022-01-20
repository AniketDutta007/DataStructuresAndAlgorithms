//Problem Statement : https://leetcode.com/problems/search-a-2d-matrix-ii/
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //Time Complexity : O(MlogN)
        int low,high,mid;
        for(int i=0; i<m; i++){
            if(matrix[i][0]<=target&&target<=matrix[i][n-1]){
                low = 0;
                high = n-1;
                while(low<=high){
                    mid = (high+low)/2;
                    if(matrix[i][mid]==target)
                        return true;
                    else if(matrix[i][mid]>target)
                        high = mid-1;
                    else
                        low = mid+1;
                }
            }
        }

        //Time Complexity : O(M+N)
        int r1,c1;
        r1 = 0;
        c1 = n-1;
        while(r1<m&&0<=c1){
            if(matrix[r1][c1]==target)
                return true;
            else if(matrix[r1][c1]<target)
                r1++;
            else
                c1--;
        }

        return false;
    }
}
