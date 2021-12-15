package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ImmutableLinkedListTest extends TestCase {
    ImmutableLinkedList list = new ImmutableLinkedList();
    @Before
    void setup() {
        for (int i : new int[]{1, 2, 3, 8, 9}) {
            list.add(i);
        }
    }

    @Test
    public void testAdd() {
        ImmutableList newlist = list.add(10);
        assertEquals(10, newlist.toArray()[newlist.size()-1]);
    }

    @Test
    public void testTestAdd() {
        ImmutableList newlist = list.add(3,4);
        assertEquals(4, newlist.get(3));
    }

    @Test
    public void testAddAll() {

    }

    public void testTestAddAll() {
    }

    public void testGet() {
    }

    public void testRemove() {
    }

    public void testSet() {
    }

    public void testIndexOf() {
    }

    public void testSize() {
    }

    public void testClear() {
    }

    public void testIsEmpty() {
    }

    public void testToArray() {
    }

    public void testAddFirst() {
    }

    public void testAddLast() {
    }

    public void testGetHead() {
    }

    public void testGetTail() {
    }

    public void testGetFirst() {
    }

    public void testGetLast() {
    }

    public void testRemoveFirst() {
    }

    public void testRemoveLast() {
    }
}