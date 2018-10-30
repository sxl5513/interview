package com.anber.interview.tree;

/**
 * Create on 2018/10/29.
 *
 * @author anber
 **/
public class TreeCreator {

    public TreeNode createSimpleTree() {
        TreeNode node = new TreeNode('A');
        node.setLeft(new TreeNode('B'));
        node.setRight(new TreeNode('C'));
        node.getLeft().setLeft(new TreeNode('D'));
        node.getLeft().setRight(new TreeNode('E'));
        node.getLeft().getRight().setLeft(new TreeNode('G'));
        node.getRight().setRight(new TreeNode('F'));
        return node;
    }

    public TreeNode createTree(String preOrder, String inOrder) {

        if (preOrder.isEmpty()) {
            return null;
        }
        /**
         * 前序 ABDEGCF  中序 DBGEACF
         * 通过前序 我们知道它的根为 A
         * 通过A对中序进行切分 可以找到对于根的左边和右边  DBGE和CF
         * 我们用递归 以及找接下来的根
         */
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        TreeNode root = new TreeNode(rootValue);
        //左边:前序下要把之前获取的根去掉 所以是1 ~~ 1 + rootIndex    中序是0 ~~ rootIndex
        root.setLeft(createTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)));
        //右边:前序也要去掉之前获取的根 以及到最后的范围 1 + rootIndex~~最后  中序 去掉之前拿去的根 1 + rootIndex ~~最后
        root.setRight(createTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)));

        return root;
    }

    public String postTree(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return "";
        }

        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        return postTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)) +
                postTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)) +
                rootValue;
    }
}
