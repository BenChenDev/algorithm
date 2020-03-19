/**
 * 
 * Given a binary tree, return the sum of values of its deepest leaves.
 

Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
 * 
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = depth(root);
        int[] res = {0};
        findSum(root, maxDepth, 1, res);
        return res[0];
    }

    private void findSum(TreeNode root, int maxDepth, int currentDepth, int[] res) {
        if (root == null) return;
        if (currentDepth == maxDepth) {
            res[0] += root.val;
        }
        findSum(root.left, maxDepth, currentDepth + 1, res);
        findSum(root.right, maxDepth, currentDepth + 1, res);
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}