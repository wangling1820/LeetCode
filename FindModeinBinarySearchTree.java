// 501. Find Mode in Binary Search Tree
// https://leetcode.com/problems/find-mode-in-binary-search-tree/
// 利用二叉排序树的中序为有序数组来则相同的节点在遍历中必相邻的特性
// 其中注意pre为空的情况的处理方式
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int maxNum = 1;
        TreeNode pre  = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null){
            while (root != null){
                    stack.push(root);
                    root = root.left;
            }
            root = stack.pop();
            if (pre != null){
                if (pre.val == root.val){
                    ++count;
                } else {
                    count = 1;
                }
                if (maxNum == count){
                    list.add(root.val);
                }else if (maxNum < count){
                    maxNum = count;
                    list.clear();
                    list.add(root.val);
                }
            }else{
                list.add(root.val);
                count = 1;
                maxNum = 1;
            }
            pre = root;
            root = root.right;
        }
        int[] res = new int[list.size()];
        for (int loc=0; loc<list.size(); ++loc){
            res[loc] = list.get(loc);
        }
        return res;
    }
}
