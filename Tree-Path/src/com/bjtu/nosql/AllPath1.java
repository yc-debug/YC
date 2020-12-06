package com.bjtu.nosql;

import java.util.ArrayList;
import java.util.List;
//遍历法
public class AllPath1 {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        find(root,String.valueOf(root.val),result);
        return result;
    }

    public void find(TreeNode root,String path,List<String> result){
        if(root==null) {
            return;
        }

        if(root.left==null && root.right==null) {
            result.add(path);
            return;
        }
        if(root.left!=null) {
            find(root.left,path+"->"+String.valueOf(root.left.val),result);
        }
        if(root.right!=null) {
            find(root.right,path+"->"+String.valueOf(root.right.val),result);
        }
    }

}
