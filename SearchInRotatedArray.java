class Solution {
    // Time: O(logn)
    // Space: O(1)
    public int search(int[] nums, int target) {
       if (nums == null || nums.length == 0){
           return -1;
       }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2 ;
            if (nums[mid] == target){
                return mid;
            }
            // if sorted
            if(nums[left] <= nums[mid]){
               if(nums[left] <= target && target < nums[mid]){
                  right = mid - 1;
               }else { // nums[left] > target || target > nums[mid]
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
        }
        // If target is not present in array
        return -1;
    }
}