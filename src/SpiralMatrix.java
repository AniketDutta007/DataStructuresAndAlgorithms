public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int k = 1;
        int i;

        //Approach : 1
        int top,right,down,left;
        top = left = 0;
        down = right = n-1;
        while(k<=n*n){
            for(i=left; i<=right; i++)
                a[top][i] = k++;
            top++;
            for(i=top; i<=down; i++)
                a[i][right] = k++;
            right--;
            for(i=right; i>=left; i--)
                a[down][i] = k++;
            down--;
            for(i=down; i>=top; i--)
                a[i][left] = k++;
            left++;
        }

        //Approach : 2
        int j;
        i = 0;
        j = 0;
        while(k<n*n){
            while(j<n-1-i)
                a[i][j++] = k++;
            while(i<j)
                a[i++][j] = k++;
            while(j>n-1-i)
                a[i][j--] = k++;
            while(i>j)
                a[i--][j] = k++;
            i++;
            j++;
        }
        if(k==n*n)
            a[i][j] = k;

        return a;
    }
}
