package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;
import ua.edu.ucu.collections.immutable.Node;

public class Queue {
    private ImmutableList queue;

    public Queue() {
        this.queue = new ImmutableLinkedList();
    }


    public Object peek() {
        return this.queue.get(0);
    }

    public Object dequeue() {
        Object temp = this.queue.get(0);
        this.queue = this.queue.remove(0);
        return temp;
    }

    public void enqueue(Object e) {
        this.queue = this.queue.add(e);
    }
}
