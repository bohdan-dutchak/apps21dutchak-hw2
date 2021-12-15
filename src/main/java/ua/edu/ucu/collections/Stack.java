package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack(){
        this.stack = new ImmutableLinkedList();
    }
    public Stack(ImmutableLinkedList stack){
        this.stack = stack;
    }

    public void push(Object e) {
        this.stack = this.stack.addFirst(e);
    }

    public Object pop() {
        if (this.stack.size()!=0) {
            Node temp = this.stack.getTail();
            this.stack = this.stack.removeLast();
            return temp;
        }
        else{
            return new Node();
        }
    }

    public Object peek() {
        return this.stack.getTail();
    }
}
