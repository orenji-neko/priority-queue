package net.core;

// Bidirectional linked-list based Queue
public class Queue<T> {
    int length;
    Node<T> head, tail;
    public Queue() {
        length = 0;
        head = null;
        tail = null;
    }
    // Getters & Setters
    public boolean isEmpty() {
        return length <= 0;
    }
    // Queue Operations
    public void enqueue(T object) {
        if(tail == null) {
            tail = new Node<T>(object);
            head = tail;
        }
        else if(tail == head) {
            tail = new Node<T>(object, null, head);
            head.setPrevPointer(tail);
        }
        else {
            Node<T> temp = new Node<>(object, null, tail);
            tail.setPrevPointer(temp);
            tail = temp;
        }
        length++;
    }
    public T dequeue() {
        Node<T> out = head;
        if(head == null && tail == null) {
            return null;
        }
        else if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.prev;
            head.setNextPointer(null);
        }
        length--;
        return out.data;
    }
    public T poll() {
        return head.data;
    }
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Node<T> current = tail; current != null; current = current.next)
            output.append(" ").append(current.data);
        return output.toString();
    }
    // static node implementation
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        Node() {
            prev = null;
            next = null;
        }
        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        // setters
        void setPointers(Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.next = next;
        }
        void setPrevPointer(Node<T> prev) {
            this.prev = prev;
        }
        void setNextPointer(Node<T> next) {
            this.next = next;
        }
    }
}