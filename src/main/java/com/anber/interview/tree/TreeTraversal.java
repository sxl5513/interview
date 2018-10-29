package com.anber.interview.tree;

/**
 * Create on 2018/10/29.
 *
 * @author anber
 **/
public class TreeTraversal {

    /**
     * 前序遍历 根->左->右
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历 左->根->右
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    /**
     * 后序遍历 左->右->根
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }

    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();

        TreeTraversal traversal = new TreeTraversal();

        traversal.preOrder(creator.createSimpleTree());
        System.out.println();

        traversal.inOrder(creator.createSimpleTree());
        System.out.println();

        traversal.postOrder(creator.createSimpleTree());
        System.out.println();

        System.out.println("===========");

        traversal.postOrder(creator.createTree("ABDEGCF", "DBGEACF"));
        System.out.println();

        traversal.postOrder(creator.createTree("", ""));
        System.out.println();

        traversal.postOrder(creator.createTree("A", "A"));
        System.out.println();

        traversal.postOrder(creator.createTree("AB", "BA"));
        System.out.println();

    }
}
