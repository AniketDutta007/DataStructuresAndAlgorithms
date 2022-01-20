public class ThreadedBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        boolean lthread;
        boolean rthread;
        TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
            this.lthread = this.rthread = true;
        }
    }
    TreeNode root;
    ThreadedBST(){
        root = null;
    }
    void insert(int val){
        TreeNode treeNode = new TreeNode(val);
        if(root==null){
            root = treeNode;
            return;
        }
        TreeNode curr = root;
        while(true){
            // curr = curr.val>=val?curr.left:curr.right;
            System.out.print(curr.val+", ");
            if(curr.val>=val){
                if(curr.left==null||curr.lthread)
                    break;
                curr = curr.left;
            } else{
                if(curr.right==null||curr.rthread)
                    break;
                curr = curr.right;
            }
        }
        if(curr.val>=val){
            treeNode.left = curr.left;
            treeNode.right = curr;
            curr.left = treeNode;
            curr.lthread = false;
        } else{
            treeNode.left = curr;
            treeNode.right = curr.right;
            curr.right = treeNode;
            curr.rthread = false;
        }
        System.out.println();
    }
    void inorder(){
        TreeNode curr = root;
        while(curr!=null){
            while(curr.left!=null&&!curr.lthread)
                curr = curr.left;
            System.out.print(curr.val+", ");
            curr = curr.right;
            if(curr!=null){
                System.out.print(curr.val+", ");
                curr = curr.right;
            }
        }
    }
    public static void main(String[] args) {
        ThreadedBST tree = new ThreadedBST();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);
        tree.inorder();
    }
}
