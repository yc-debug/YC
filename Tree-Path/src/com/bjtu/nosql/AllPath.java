package com.bjtu.nosql;

import java.util.List;
import java.util.ArrayList;
//分治法
public class AllPath {

    public List<String>binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
        {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path: leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path: rightPaths) {
            paths.add(root.val + "->" + path);
        }

        if(paths.size() == 0) {
            paths.add("" + root.val);
        }


        return paths;
    }

    /* test function
    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root.val = 0;

        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        root.left = node1;
        root.right = node2;
        node1.left = node3;

        Allpath a = new Allpath();

        System.out.println(a.binaryTreePaths(root));

    }*/

}
