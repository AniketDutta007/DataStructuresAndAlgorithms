//Problem Statement : https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int c = 0;

        // int sum;
        // for(int i=0; i<nums.length; i++){
        //     sum = 0;
        //     for(int j=i; j<nums.length; j++){
        //         sum+= nums[j];
        //         if(sum==k){
        //             c++;
        //         }
        //     }
        // }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<sum.length; i++)
            sum[i] = sum[i-1]+nums[i];

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(sum[i]==k)//to check if the entire subarray is equal to the target i.e [0,i]
                c++;
            if(map.containsKey(sum[i]-k))//to check if there is any portion of the subarray i.e equal to the target
                c+= map.get(sum[i]-k);
            map.put(sum[i],(map.containsKey(sum[i])?map.get(sum[i]):0)+1);
        }

        return c;
    }
}
