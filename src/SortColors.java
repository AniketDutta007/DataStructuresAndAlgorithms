//Problem Statement : https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sortColors(int[] nums) {
        // int i = 0;
        // int[] freq = new int[3];
        // for(int color : nums)
        //     freq[color]++;
        // for(int color=0; color<=2; color++)
        //     while(freq[color]-->0)
        //         nums[i++] = color;

        //Dutch National Flag Algorithm
        int low,mid,high;
        low = mid = 0;
        high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
