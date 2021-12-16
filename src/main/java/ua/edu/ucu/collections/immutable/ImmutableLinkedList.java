package ua.edu.ucu.collections.immutable;

import java.util.PriorityQueue;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        this.head = new Node();

        if (elements.length == 1) {
            this.head.setValue(elements[0]);
            this.tail = head;
        } else {
            Node current = this.head;
            for (int i = 0; i < elements.length; i++) {
                current.setValue(elements[i]);
                if (i != elements.length - 1) {
                    Node next = new Node();
                    next.setPrevious(current);
                    current.setNext(next);
                    current = next;
                } else {
                    this.tail = current;
                }
            }
        }

    }

    public ImmutableLinkedList() {
        this.head = new Node();
        this.tail = this.head;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] result;
        if(this.get(0) == null){
            result = new Object[this.size()];
        }
        else {
            result = new Object[this.size() + 1];
        }
        Object[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        result[result.length - 1] = e;
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] result = new Object[this.size() + 1];
        Object[] arr = this.toArray();
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        result[index] = e;
        for (int i = index + 1; i < result.length; i++){
            result[i] = arr[i-1];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] result = new Object[this.size() + c.length];
        Object[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < c.length; i++){
            result[i+arr.length] = c[i];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] result = new Object[this.size() + c.length];
        Object[] arr = this.toArray();
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < c.length; i++) {
            result[i+index] = c[i];
        }
        for (int i = index; i < arr.length; i++) {
            result[i+c.length] = arr[i];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public Object get(int index) {
        return this.toArray()[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] arr = this.toArray();
        Object[] removed = new Object[arr.length-1];
        for(int i = 0; i<index; i++){
            removed[i] = arr[i];
        }
        for(int i = index+1; i<arr.length; i++){
            removed[i-1] = arr[i];
        }
        return new ImmutableLinkedList(removed);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] result = this.toArray();
        result[index] = e;
        return  new ImmutableLinkedList(result);
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;
        Object[] arr = this.toArray();
        for (int i = 0; i<arr.length; i++){
            if(arr[i] == e){
                return i;
            }
        }
        return index;
    }

    @Override
    public int size() {
        int counter = 0;
        Node current = this.head;
        while (current != null) {
            current = current.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 1 && this.get(0)==null){
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size()];
        int i = 0;
        Node current = this.head;
        while (current != null) {
            arr[i] = current.getValue();
            i++;
            current = current.getNext();
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] result;
        if(this.get(0) == null){
            result = new Object[this.size()];
        }
        else {
            result = new Object[this.size() + 1];
        }
        Object[] arr = this.toArray();
        result[0] = e;
        for (int i =0; i< arr.length; i++){
            result[i+1] = arr[i];
        }
        return new ImmutableLinkedList(result);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] result;
        if(this.get(0) == null){
            result = new Object[this.size()];
        }
        else {
            result = new Object[this.size() + 1];
        }
        Object[] arr = this.toArray();
        for (int i =0; i< arr.length; i++){
            result[i] = arr[i];
        }
        result[result.length-1] = e;
        return new ImmutableLinkedList(result);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        return getHead().getValue();
    }

    public Object getLast() {
        return getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] arr = this.toArray();
        Object[] removed = new Object[arr.length-1];
        for (int i = 0; i<removed.length; i++){
            removed[i] = arr[i+1];
        }
        return  new ImmutableLinkedList(removed);
    }

    public ImmutableLinkedList removeLast() {
        Object[] arr = this.toArray();
        Object[] removed = new Object[arr.length-1];
        for (int i = 0; i<removed.length; i++){
            removed[i] = arr[i];
        }
        return  new ImmutableLinkedList(removed);
    }
}
