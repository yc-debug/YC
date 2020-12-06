package com.bjtu.nosql;

public class Tree {
    private TreeNode minRoot;
    private int minSum;

    public TreeNode finSubTree(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        minRoot = null;
        getSum(root);
        return minRoot;
    }

    private int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = getSum(root.left) + getSum(root.right) + root.val;
        if(sum<minSum) {
            minSum = sum;
            minRoot = root;
        }

        return sum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root.val = 0;

        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right=node4;

        AllPath a = new AllPath();
        System.out.println("分治法结果：");
        System.out.println(a.binaryTreePaths(root));

        AllPath1 b=new AllPath1();
        System.out.println("遍历法结果：");
        System.out.println(b.binaryTreePaths(root));
    }
}
