//Problem Statement : https://leetcode.com/problems/increasing-triplet-subsequence/

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int i,j;
        i = j = Integer.MAX_VALUE;
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind]<=i)
                i = nums[ind];
            else if(nums[ind]<=j)
                j = nums[ind];
            else
                return true;
        }
        return false;
    }
}
