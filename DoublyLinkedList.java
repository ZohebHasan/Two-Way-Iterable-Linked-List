// Author - Zoheb Hasan - 114687894 - CSE214 HW1 - Fall 2022
package cse214hw1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements ListAbstractType<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    private static class Node<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E input) {
            element = input;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    @Override
    public TwoWayListIterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }
    @Override
    public boolean add(E element) {
        Node<E> new_node = new Node<>(element);
        if (this.isEmpty()) {
            head = new_node;
            tail = head;
        } else {
            new_node.prev = tail;
            tail.setNext(new_node);
            tail = tail.getNext();
        }
        length++;
        return true;
    }

    //tik tik
    @Override
    public boolean remove(E element) {
        if (this.isEmpty()) {
            return false;
        }
        if (this.contains(element)) {
            Node<E> temp = head;
            while (temp != null) {
                if (temp.getElement() == element) {
                    if (head == temp) {
                        head = temp.next;
                        this.length--;
                        return true;
                    }
                    //our node is a tail
                    if (temp.next == null) {
                        tail = tail.prev;
                        tail.next = null;
                        this.length--;
                        return true;
                    }
                    if (temp.next != null) {
                        temp.next.prev = temp.next;
                        this.length--;
                        return true;
                    }
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                        this.length--;
                        return true;
                    }
                }
                temp = temp.next;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.length;
    }


    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }
    @Override
    public boolean contains(E element) {
        Node<E> temp = head;
        while (temp != null) {
            if (element == temp.getElement()) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    @Override
    public void add(int index, E element) {
        Node<E> new_node = new Node(element);
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //if our node is tail
        if (temp.next == null) {
            temp.next = new_node;
            new_node.prev = temp;
            tail = tail.next;
            length++;
            return;
        }

        temp.next.prev = new_node;
        new_node.next = temp.next;
        new_node.prev = temp;
        temp.next = new_node;
        length++;

        return;
    }
    @Override
    public E set(int index, E element) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        E prevElement = temp.getElement();
        temp.setElement(element);
        return prevElement;
    }

    //tik tik
    @Override
    public E get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (index < length - 1) {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getElement();
        }
        return tail.getElement();
    }

    @Override
    public void remove(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp == head) {
            head = head.next;
            length--;
            return;
        }
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            length--;
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        length--;
        return;
    }

    private class DoublyLinkedListIterator implements TwoWayListIterator<E> {

        private Node<E> current;
        Node<E> firstSet = null;
        int lastLength = length;

        public DoublyLinkedListIterator() {
            current = head;
        }

        //perfect
        @Override
        public void add(E element) {
            Node<E> new_node = new Node(element);
            if (isEmpty()) {
                head = new_node;
                tail = head;
                length++;
                return;
            }
            if (current == null) {
                throw new UnsupportedOperationException();
            } else if (current.prev == null) {
                current.prev = new_node;
                new_node.next = current;
                head = new_node;
            } else {
                Node<E> previous = current.prev;
                new_node.next = current;
                new_node.prev = previous;
                current.prev = new_node;
                previous.next = new_node;
            }
            length++;
        }

        //perfect
        @Override
        public boolean hasPrevious() {
            if (current == head || head == null) {
                return false;
            } else {
                return true;
            }
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E previous() {
            if (current == head || head == null) {
                throw new NoSuchElementException();
            } else {
                current = current.getPrev();
                lastLength = length;
                return current.getElement();
            }
        }
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E temp = current.getElement();
            current = current.next;
            lastLength = length;
            return temp;
        }
        @Override
        public void set(E element) {
            if(isEmpty()){
                throw new UnsupportedOperationException();
            }
            if (firstSet == current || lastLength != length) {
                throw new IllegalStateException();
            }
            if (current == tail || hasNext()) {
                current.element = element;
            } else {
                throw new UnsupportedOperationException();
            }
            firstSet = current;
            lastLength = length;
        }
    }
    public String toString() {
        Iterator<E> it = this.iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        while (it.hasNext()) {
            E e = it.next();
            builder.append(e.toString());
            if (!it.hasNext()) {
                return builder.append("]").toString();
            }
            builder.append(",");
        }
        return null;
    }
}
