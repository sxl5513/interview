package com.anber.interview.tree;

/**
 * Create on 2018/10/29.
 *
 * @author anber
 **/
public class TreeCreator {

    public TreeNode createSimpleTree() {
        TreeNode node = new TreeNode("A");
        node.setLeft(new TreeNode("B"));
        node.setRight(new TreeNode("C"));
        node.getLeft().setLeft(new TreeNode("D"));
        node.getLeft().setRight(new TreeNode("E"));
        node.getLeft().getRight().setLeft(new TreeNode("G"));
        node.getRight().setRight(new TreeNode("F"));
        return node;
    }
}
