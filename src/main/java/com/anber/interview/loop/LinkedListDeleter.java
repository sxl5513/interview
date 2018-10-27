package com.anber.interview.loop;

import com.anber.interview.common.Node;
import com.anber.interview.recursion.LinkedListCreator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author anber
 * @Date 2018/10/27
 */
public class LinkedListDeleter {

    public Node deleteIfEquals(Node head, int value) {
        while (head != null && head.getValue() == value) {
            head = head.getNext();
        }

        if (head == null) {
            return null;
        }

        Node prev = head;
        while (prev.getNext() != null) {
            if (prev.getNext().getValue() == value) {
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;
    }

    public static void main(String[] args) {

        LinkedListCreator creator = new LinkedListCreator();
        LinkedListDeleter deleter = new LinkedListDeleter();

        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(Arrays.asList(1, 2, 3, 2, 5)), 2));
        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(Arrays.asList(2, 2, 3, 2, 5)), 2));
        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(Arrays.asList(3, 2, 3, 2, 5)), 3));
        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(new ArrayList()), 2));
        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(Arrays.asList(2)), 2));
        Node.printLinkedList(deleter.deleteIfEquals(creator.createLinkedList(Arrays.asList(2)), 1));


    }
}
