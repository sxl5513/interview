package com.anber.interview.tree;

/**
 * @author anber
 * @date 2018/10/31
 **/
public class InOrder {

    public TreeNode next(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return first(node.getRight());
        } else {
            while (node.getParent() != null &&
                    node.getParent().getLeft() != null){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    private TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode curNode = node;
        while (curNode.getLeft() != null) {
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    public static void main(String[] args) {

    }
}
