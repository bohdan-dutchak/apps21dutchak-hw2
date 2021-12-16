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
        if (this.queue.size() != 0) {
            Object temp = this.queue.get(0);
            this.queue = this.queue.remove(0);
            return temp;
        } else {
            return new Node();
        }
    }

    public void enqueue(Object e) {
        if (this.queue.size() == 1) {
            this.queue = this.queue.add(e);
        } else {
            this.queue = this.queue.add(e);
        }
    }
}
