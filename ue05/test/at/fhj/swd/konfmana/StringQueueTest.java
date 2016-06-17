package at.fhj.swd.konfmana;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import at.fhj.swd.konfmana.Queue;
import at.fhj.swd.konfmana.StringQueue;

public class StringQueueTest {
	
	private Queue queue;
	
	@Before
	public void setup(){
		queue = new StringQueue(4);
		
		queue.offer("first");
		queue.offer("second");
		queue.offer("third");
	}

	@Test
	public void testOffer() {
		assertTrue(queue.offer("fourth"));
	}
	
	@Test
	public void testOfferPoll(){
		queue.offer("fourth");
		queue.poll();
		queue.poll();
		queue.poll();
		assertEquals("fourth", queue.poll());
	}
	
	@Test
	public void testPoll(){
		assertEquals("first", queue.poll());
		assertEquals("second", queue.poll());
		assertEquals("third", queue.poll());
		assertEquals(null, queue.poll());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemove(){	
		assertEquals("first", queue.remove());
		assertEquals("second", queue.remove());
		assertEquals("third", queue.remove());
		queue.remove();
	}
	
	@Test
	public void testPeek(){
		assertEquals("first", queue.peek());
		assertEquals("first", queue.peek());
		assertEquals("first", queue.peek());
		assertEquals("first", queue.peek());
		assertEquals("first", queue.peek());
		assertEquals("first", queue.peek());
		assertEquals("first", queue.remove());
		assertEquals("second", queue.remove());
		assertEquals("third", queue.remove());	
		assertEquals(null, queue.peek());	
	}

	@Test(expected=NoSuchElementException.class)
	public void testElement(){
		assertEquals("first", queue.element());
		assertEquals("first", queue.element());
		assertEquals("first", queue.element());
		assertEquals("first", queue.element());
		assertEquals("first", queue.element());
		assertEquals("first", queue.element());
		assertEquals("first", queue.remove());
		assertEquals("second", queue.remove());
		assertEquals("third", queue.remove());	
		queue.element();	
	}
	
	/**
	 * What do you expect?
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testZeroMaxQueueSize(){
		queue = new StringQueue(0);
	}
	
	/**
	 * What do you expect?
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeMaxQueueSize(){
		queue = new StringQueue(-1);
	}
	
	/**
	 * Write a test to that shows
	 * that you cannot insert (offer) more elements
	 * into the Queue than defined by maxSize
	 */
	@Test
	public void testQueueTooSmall() {
		queue = new StringQueue();	// creates a Queue with maxSize = 1
		assertEquals (true, queue.offer("Element1"));
		assertEquals (false, queue.offer("Element2"));
	}
}
