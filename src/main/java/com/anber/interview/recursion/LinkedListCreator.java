package com.anber.interview.recursion;

import com.anber.interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anber
 * @Date 2018/10/24
 */
public class LinkedListCreator {

    /**
     * Creates a linked list
     *
     * @param data the data to create the list
     * @return head of the linked list.The returned linked list
     * ends with last node with getNext()==null
     */
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        firstNode.setNext(createLinkedList(data.subList(1, data.size())));
        return firstNode;
    }

    public Node createLargeLinkedList(int size) {
        Node prev = null;
        Node head = null;
        for (int i = 1; i <= size; i++) {
            Node node = new Node(i);
            if (prev != null) {
                prev.setNext(node);
            } else {
                head = node;
            }
            prev = node;
        }
        /**
         * 在运行 head = node时  两个变量指向内存地址相同
         * 当 prev = node时 head prev 和 node 指向的内存地址相同
         * node = new Node（）时  node指向新的内存地址
         * 而prev 和 node  指向内存地址是一直相同
         * 所以当prev 对数据更改时 node的数据也在更改 两个变量中的next对象 指向的内存地址 是之前刚刚new出的node()
         * 依次往下
         */
        return head;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1,2,3,4,5)));

        creator.createLargeLinkedList(100);
    }
}
