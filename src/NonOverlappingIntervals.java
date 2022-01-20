//Problem Statement : https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        // sortByStart(intervals,0,intervals.length-1);
        int prevStart,prevEnd;
        int start,end;
        prevStart = intervals[0][0];
        prevEnd = intervals[0][1];
        int c = 0;
        for(int i=1; i<intervals.length; i++){
            start = intervals[i][0];
            end = intervals[i][1];
            if(prevEnd<=start||prevStart>=end){
                prevStart = start;
                prevEnd = end;
            } else{
                if(end<prevEnd){
                    prevStart = start;
                    prevEnd = end;
                }
                c++;

            }
        }
        return c;
    }
    public void sortByStart(int[][] intervals,int lb,int ub){
        if(lb>=ub)
            return;
        int pi = partition(intervals,lb,ub);
        sortByStart(intervals,lb,pi-1);
        sortByStart(intervals,pi+1,ub);
    }
    public int partition(int[][] intervals,int lb,int ub){
        int pivot = intervals[ub][0];
        int i = lb-1;
        int[] temp;
        for(int j=lb; j<=ub-1; j++){
            if(intervals[j][0]<pivot){
                i++;
                temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        temp = intervals[i+1];
        intervals[i+1] = intervals[ub];
        intervals[ub] = temp;
        return i+1;
    }
}
