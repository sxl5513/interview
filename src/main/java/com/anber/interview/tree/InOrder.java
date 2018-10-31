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
                    node.getParent().getLeft() != node){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node) {
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
        TreeCreator creator = new TreeCreator();
        InOrder inOrder = new InOrder();

        TreeNode simpleTree = creator.createSimpleTree();

        for (TreeNode node = inOrder.first(simpleTree); node != null; node = inOrder.next(node)) {
            System.out.print(node.getValue());
        }
        System.out.println();
    }
}
