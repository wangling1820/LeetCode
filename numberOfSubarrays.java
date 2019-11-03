// 1248. Count Number of Nice Subarrays
// https://leetcode.com/problems/count-number-of-nice-subarrays/
// Sliding Window 
// 滑动窗口题集:等待补充
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int pre = -1;
        int count = 0;
        for (int left=0, right=0; right<nums.length; ++right){
            if ((nums[right] & 1) != 0) ++count;
            if ((nums[left] & 1) == 0) ++left;
            if (count == k) ans += left - pre;
            if (count > k){
                pre = left;
                for (;(nums[++left] & 1) == 0;);
                --count;
                ans += left - pre;
            }
        }
        return ans;
    }
}