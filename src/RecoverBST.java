//Problem Statement : https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorderViolationDetector(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorderViolationDetector(TreeNode root){
        if(root==null)
            return;
        inorderViolationDetector(root.left);
        if(prev!=null&&prev.val>root.val){
            if(first==null)
                first = prev;
            second = root;
        }
        prev = root;
        inorderViolationDetector(root.right);
    }
}
