// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/
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
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!isValidBST(root.left)) 
            return false;
        
        if (pre != null && pre.val >= root.val)
            return false;
        
        pre = root; //保存中序遍历的前驱结点
        
        if (!isValidBST(root.right))
            return false;
        
        return true;
    }
}