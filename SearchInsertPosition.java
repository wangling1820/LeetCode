/* 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 * 二分查找
 * /
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid=0;
        while (low <= high){
            mid = ((high - low) >> 1) + low;
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
            else return mid;
        }
        return low;
    }
}