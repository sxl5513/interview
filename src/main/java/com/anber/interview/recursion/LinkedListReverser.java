package com.anber.interview.recursion;

import com.anber.interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author anber
 * @Date 2018/10/24
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();

        Node.printLinkedList(reverser.reverseLinkedList(
                creator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverser.reverseLinkedList(
                creator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverser.reverseLinkedList(
                creator.createLinkedList(Arrays.asList(1,2,3,4,5))));

        //报错 java.lang.StackOverflowError
//        reverser.reverseLinkedList(creator.createLargeLinkedList(100000));
//        System.out.println("done");
    }
}
