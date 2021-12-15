package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        this.head = new Node();
        this.tail = new Node();;
        Node current = head;

        for (int i = 0; i < elements.length; i++) {
            current.setValue(elements[i]);
            Node next = new Node();
            next.setPrevious(current);
            current.setNext(next);
            if (i == elements.length - 1) {
                this.tail = current.getPrevious();
            }
        }

    }

    public ImmutableLinkedList() {
        this.head = new Node();
        this.tail = new Node();
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] els = this.toArray();
        Object[] result = new Object[els.length+1];
        for (int i = 0; i<els.length; i++){
            result[i] = els[i];
        }
        result[result.length-1] = e;
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] els = this.toArray();
        Object[] result = new Object[els.length+1];
        for (int i = 0; i<index; i++){
            result[i] = els[i];
        }
        for (int i = index; i< result.length; i++){
            result[i] = els[i];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] els = this.toArray();
        Object[] result = new Object[els.length+c.length];
        for (int i = 0; i<els.length; i++){
            result[i] = els[i];
        }
        for (int i = 0; i< c.length; i++){
            result[i+els.length] = els[i];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] els = this.toArray();
        Object[] result = new Object[els.length+c.length];
        for (int i = 0; i < index; i++){
            result[i] = els[i];
        }
        for (int i = 0; i < c.length; i++){
            result[i+index] = c[i];
        }
        for (int i = 0; i < els.length - index; i++){
            result[i+index+c.length] = els[i+index+1];
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public Object get(int index) {
        Object[] temp = this.toArray();
        return temp[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] temp = this.toArray();
        Object[] removed = new Object[temp.length-1];
        for (int i = 0; i<index; i++){
            removed[i] = temp[i];
        }
        for (int i = 0; i< temp.length-index; i++){
            removed[i] = temp[i];
        }
        return new ImmutableLinkedList(removed);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] temp = this.toArray();
        temp[index] = e;
        return new ImmutableLinkedList(temp);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node current = this.getHead();
         while (current != null) {
             if (current.getValue()==e){
                 return index;
             }
             index++;
             current = current.getNext();
         }
         return -1;
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        int size = this.size();
        Object[] result = new Object[this.size()];
        Node current = this.getHead();
        for (int i = 0; i < size; i++){
            result[i] = current.getValue();
            current.getNext();
        }
        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] els = this.toArray();
        Object[] result = new Object[this.size()+1];
        result[0] = e;
        for (int i = 0; i< els.length; i++){
            result[i+1] = els[i];
        }
        return new ImmutableLinkedList(result);

    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] els = this.toArray();
        Object[] result = new Object[this.size()+1];
        for (int i = 0; i< els.length; i++){
            result[i] = els[i];
        }
        result[0] = e;
        return new ImmutableLinkedList(result);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        return this.head.getValue();
    }

    public Object getLast() {
        return this.tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] els = this.toArray();
        Object[] removed = new Object[els.length-1];
        for (int i = 0; i<removed.length; i++){
            removed[i] = els[i+1];
        }
        return new ImmutableLinkedList(removed);
    }

    public ImmutableLinkedList removeLast() {
        Object[] els = this.toArray();
        Object[] removed = new Object[els.length-1];
        for (int i = 0; i<removed.length; i++){
            removed[i] = els[i];
        }
        return new ImmutableLinkedList(removed);
    }
}
