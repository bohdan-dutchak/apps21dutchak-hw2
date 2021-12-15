package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue(){
        this.queue = new ImmutableLinkedList();
    }
    public Queue(ImmutableLinkedList queue){
        this.queue = queue;
    }

    public Object peek() {
        return this.queue.getHead();
    }

    public Object dequeue() {
        if (this.queue.size()!=0) {
            Node temp = this.queue.getHead();
            this.queue = this.queue.removeFirst();
            return temp;
        }
        else{
            return new Node();
        }
    }

    public void enqueue(Object e) {
        this.queue = this.queue.addLast(e);
    }
}
