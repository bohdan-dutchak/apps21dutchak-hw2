package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ImmutableLinkedListTest extends TestCase {

    public void testEmptyConstr(){
        ImmutableList list = new ImmutableLinkedList();
        int actual = list.size();
        assertEquals(1, actual);
    }

    public void testConstr(){
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        Object[] elsarr = list.toArray();
        for (int i = 0; i<els.length; i++){
            assertEquals(i+1, elsarr[i]);
        }
    }

    @Test
    public void testAdd() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.add(6);
        Object[] listarr = list.toArray();
        for (int i = 0; i<list.size(); i++){
            assertEquals(i+1, listarr[i]);
        }
    }

    public void testTestAdd() {
        Object[] els = new Object[]{1,2,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.add(2,3);
        Object[] listarr = list.toArray();
        for (int i = 0; i<list.size(); i++){
            assertEquals(i+1, listarr[i]);
        }
    }

    public void testAddAll() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.addAll(new Object[]{6,7,8});
        Object[] listarr = list.toArray();
        for (int i = 0; i<list.size(); i++){
            assertEquals(i+1, listarr[i]);
        }
    }

    public void testTestAddAll() {
        Object[] els = new Object[]{1,4};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.addAll(1,new Object[]{2,3});
        Object[] listarr = list.toArray();
        for (int i = 0; i<list.size(); i++){
            assertEquals(i+1, listarr[i]);
        }
    }

    public void testGet() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        for(int i = 0; i< list.size(); i++){
            assertEquals(i+1, list.get(i));
        }
    }

    public void testRemove() {
        Object[] els = new Object[]{1,2,3,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.remove(2);
        for (int i =0; i<list.size(); i++){
            assertEquals(i+1, list.get(i));
        }
    }

    public void testSet() {
        Object[] els = new Object[]{0,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        list = list.set(0,1);
        assertEquals(1, list.get(0));
    }

    public void testIndexOfPresent() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        assertEquals(2, list.indexOf(3));
    }

    public void testIndexOfAbsent() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        assertEquals(-1, list.indexOf(10));
    }

    public void testSize() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        assertEquals(5, list.size());
    }

    public void testClear() {
        ImmutableList list = new ImmutableLinkedList(new Object[]{1,2,3,4,5,5,1});
        list = list.clear();
        assertEquals(1, list.size());
    }

    public void testIsEmpty() {
        ImmutableList list = new ImmutableLinkedList(new Object[]{1,2,3,4,5,5,1});
        list = list.clear();
        assertEquals(true, list.isEmpty());
    }

    public void testToArray() {
        Object[] els = new Object[]{1,2,3,4,5};
        ImmutableList list = new ImmutableLinkedList(els);
        Object[] arr = list.toArray();
        for (int i = 0; i<els.length; i++){
            assertEquals(els[i], arr[i]);
        }
    }

    public void testAddFirst() {
        Object[] els = new Object[]{2,3,4,5};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        list = list.addFirst(1);
        for (int i = 0; i<els.length+1; i++){
            assertEquals(i+1, list.get(i));
        }
    }

    public void testAddLast() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        list = list.addLast(5);
        for (int i = 0; i<els.length+1; i++){
            assertEquals(i+1, list.get(i));
        }
    }

    public void testGetHead() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        assertEquals(1, list.getHead().getValue());
    }

    public void testGetTail() {Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        assertEquals(4, list.getTail().getValue());
    }

    public void testGetFirst() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        assertEquals(1, list.getFirst());
    }

    public void testGetLast() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        assertEquals(4, list.getLast());
    }

    public void testRemoveFirst() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        list = list.removeFirst();
        for(int i = 0; i<list.size(); i++){
            assertEquals(i+2, list.get(i));
        }
    }

    public void testRemoveLast() {
        Object[] els = new Object[]{1,2,3,4};
        ImmutableLinkedList list = new ImmutableLinkedList(els);
        list = list.removeLast();
        for(int i = 0; i<list.size(); i++){
            assertEquals(i+1, list.get(i));
        }
    }
}