//Problem Statement : https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {

        //Moore's Voting Algorithm
        int majority = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=majority){
                count--;
                if(count<=0){
                    majority = nums[i];
                    count = 1;
                }
            } else
                count++;
        }
        return majority;
    }
}
