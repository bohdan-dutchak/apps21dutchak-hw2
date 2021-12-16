package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ImmutableArrayListTest extends TestCase {

    @Test
    public void testAdd() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.add(6);
        for (int i = 0; i<list.size(); i++){
            assertEquals(i+1, list.get(i));
        }
    }

    @Test
    public void testTestAdd() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.add(0,0);
        assertEquals(5, list.get(5));
    }

    @Test
    public void testAddAll() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.addAll(new Object[]{6,7,8,9});
        for (int i = 0; i < 9; i++){
            assertEquals(i+1, list.get(i));
        }
    }

    @Test
    public void testTestAddAll() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.addAll(2, new Object[]{3,3});
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(3, list.get(4));
        assertEquals(4, list.get(5));
        assertEquals(5, list.get(6));
    }

    @Test
    public void testGet() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        assertEquals(list.get(0), 1);
    }

    @Test
    public void testRemove() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.remove(4);
        assertEquals(5, list.get(list.size()-1));
    }

    @Test
    public void testSet() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        assertEquals(69, list.set(0, 69).get(0));
    }

    @Test
    public void testIndexOf() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    public void testSize() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        assertEquals(5,list.size());
    }

    @Test
    public void testClear() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        list = list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        assertEquals(false, list.isEmpty());
    }

    public void testIsNotEmpty() {
        ImmutableList list = new ImmutableArrayList(new Object[]{1,2,3,4,5,5,1});
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableList list;
        Object[] els = new Object[]{1,2,3,4,5};
        list = new ImmutableArrayList(els);
        Object[] elss = list.toArray();
        for (int i = 0; i<elss.length; i++){
            assertEquals(els[i], list.get(i));
        }
    }
}