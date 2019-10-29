/* 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 使用队列和ArrayList的头插入实现遍历
 * 使用level来确定遍历的方向，在从右向左的遍历中使用ArrayList.add(0, treeNode.val)记录结点的值
 * /

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode temp;
            int nums = queue.size();
            while (nums-- > 0){
                temp = queue.poll();
                if ((level & 1) == 0) list.add(temp.val);
                else list.add(0, temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            ++level;
            res.add(list);
        }
        return res;
    }
}