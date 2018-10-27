package com.anber.interview.loop;

import com.anber.interview.common.Node;
import com.anber.interview.recursion.LinkedListCreator;

import java.util.Arrays;

/**
 * @author anber
 * @Date 2018/10/27
 */
public class LinkedListReverser {


    public Node reverseLinkedList(Node head) {
        Node newHead = null;
        Node curHead = head;

        while (curHead != null) {
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();
        Node.printLinkedList(reverser.reverseLinkedList(
                creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
