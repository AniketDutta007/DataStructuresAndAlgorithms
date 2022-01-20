//Problem Statement : https://leetcode.com/problems/3sum/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        int i,previ;
        int low,prevLow;
        int high,prevHigh;
        int target;
        Arrays.sort(nums);
        i = 0;
        while(i<n){
            low = i+1;
            high = n-1;
            target = -nums[i];
            //Algorithm to find two no.s adding upto to given no.
            while(low<high){
                if(nums[low]+nums[high]==target){
                    res.add(new LinkedList<>());
                    res.get(res.size()-1).add(nums[i]);
                    res.get(res.size()-1).add(nums[low]);
                    res.get(res.size()-1).add(nums[high]);

                    prevLow = nums[low];
                    while(low<n&&prevLow==nums[low])
                        low++;

                    prevHigh = nums[high];
                    while(0<=high&&prevHigh==nums[high])
                        high--;

                } else if(nums[low]+nums[high]<target){
                    prevLow = nums[low];
                    while(low<n&&prevLow==nums[low])
                        low++;
                } else{
                    prevHigh = nums[high];
                    while(0<=high&&prevHigh==nums[high])
                        high--;
                }
            }
            previ = nums[i];
            while(i<n&&previ==nums[i])
                i++;
        }
        return res;
    }
}
