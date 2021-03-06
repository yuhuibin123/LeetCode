/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
//算法思想，遍历二叉树，遇到根节点的时候判断是非路径上节点的和等于目标数值
public class Solution {
    private boolean traverse(TreeNode p, int sum, int tmpSum) {
        if (p != null) {
            tmpSum += p.val;
            if (p.left == null && p.right == null) {
                if (tmpSum == sum)
                    return true;
            } else {
                if (traverse(p.left, sum, tmpSum))
                    return true;
                if (traverse(p.right, sum, tmpSum))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        int tmpSum = 0;
        return traverse(root, sum, tmpSum);
    }
}
