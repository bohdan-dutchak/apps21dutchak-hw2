package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        this.stack = new ImmutableLinkedList();
    }


    public void push(Object e) {
        this.stack = this.stack.addLast(e);
    }

    public Object pop() {
        Node temp = this.stack.getTail();
        this.stack = this.stack.removeLast();
        return temp.getValue();
    }

    public Object peek() {
        return this.stack.getTail().getValue();
    }
}
