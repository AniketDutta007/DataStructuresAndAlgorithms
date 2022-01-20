//Problem Statement : https://leetcode.com/problems/merge-intervals/

import java.util.List;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        // Sort by ascending starting point
        // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        sortByStart(intervals,0,n-1);

        int prevStart, prevEnd, start, end;
        prevStart = intervals[0][0];
        prevEnd = intervals[0][1];

        List<int[]> res = new LinkedList<>();

        for(int i=1; i<n; i++){
            start = intervals[i][0];
            end = intervals[i][1];
            if(prevEnd<start||prevStart>end){
                res.add(new int[2]);
                res.get(res.size()-1)[0] = prevStart;
                res.get(res.size()-1)[1] = prevEnd;
                prevStart = start;
                prevEnd = end;
            } else{
                prevStart = (int)Math.min(start,prevStart);
                prevEnd = (int)Math.max(end,prevEnd);
            }
        }
        res.add(new int[2]);
        res.get(res.size()-1)[0] = prevStart;
        res.get(res.size()-1)[1] = prevEnd;

        return res.toArray(new int[res.size()][]);
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
