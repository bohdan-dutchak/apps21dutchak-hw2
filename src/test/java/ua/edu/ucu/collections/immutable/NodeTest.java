package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class NodeTest extends TestCase {
    private Node node;
    @Before
    public void setUp(){
        this.node = new Node();
    }

    @Test
    public void testTestToString() {
        this.node.setValue(69);
        assertEquals("69",this.node.toString());
    }

    @Test
    public void testGetPrevious() {
        assertEquals(null, this.node.getPrevious());
    }

    @Test
    public void testSetPrevious() {
        Node prev = new Node();
        this.node.setPrevious(prev);
        assertEquals(prev, this.node.getPrevious());
    }

    @Test
    public void testGetValue() {
        this.node.setValue(5);
        assertEquals(5, this.node.getValue());
    }

    @Test
    public void testSetValue() {
        this.node.setValue(5);
        assertEquals(5, this.node.getValue());
    }

    @Test
    public void testGetNext() {
        Node next = new Node();
        this.node.setNext(next);
        assertEquals(next, this.node.getNext());
    }

    @Test
    public void testSetNext() {
        Node next = new Node();
        this.node.setNext(next);
        assertEquals(next, this.node.getNext());
    }
}