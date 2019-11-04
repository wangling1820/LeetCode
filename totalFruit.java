// 904. Fruit Into Baskets
// https://leetcode.com/problems/fruit-into-baskets/
// sliding window
class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0, right=0;    // 窗口的左右
        int max = 0;    // 结果
        for(; right<tree.length; ++right){
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            while (map.size() > 2){     // 窗口数据溢出时
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) 
                    map.remove(tree[left]);
                ++left;     // 更改窗口的左边
            }
            max = Math.max(max, right - left + 1);  // 记录此时窗口的大小
        }
        return max;
    }
}