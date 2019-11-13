// 1248. Count Number of Nice Subarrays
// https://leetcode.com/problems/count-number-of-nice-subarrays/
// Sliding Window 
// 滑动窗口题集:等待补充
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0; // 结果
        int pre = -1; // 保存上次奇数的位置
        int count = 0; // 统计奇数的个数
        for (int left=0, right=0; right<nums.length; ++right){ // left：窗口左边1的位置；right：窗口右边1的位置 
            if ((nums[right] & 1) != 0) ++count; 
            if ((nums[left] & 1) == 0) ++left;     
            if (count == k) ans += left - pre;      // 更新ans
            if (count > k){     //当count > k时 滑动窗口
                pre = left;    //更新pre
                for (;(nums[++left] & 1) == 0;);    //更改窗口left1的位置
                --count;    //窗口滑动 减少1的个数
                ans += left - pre;     // 更新ans
            }
        }
        return ans;
    }
}