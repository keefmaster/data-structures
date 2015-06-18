package io.leonid.ds.fifopriorityqueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Leonid Yakubov on 18.06.2015.
 */
public class FIFOPriorityQueueTest {
    private FIFOPriorityQueue<Message> queue;
    private Message messageA;
    private Message messageB;
    private Message messageC;
    private Message messageD;

    @Before
    public void setUp() throws Exception {
        queue = new FIFOPriorityQueue<Message>();
        messageA = new Message(Message.InstructionType.A, "Message A");
        messageB = new Message(Message.InstructionType.B, "Message B");
        messageC = new Message(Message.InstructionType.C, "Message C");
        messageD = new Message(Message.InstructionType.D, "Message D");
    }

    @Test
    public void testIsEmptyShouldReturnTrueIfQueueIsEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyShouldReturnFalseIfQueueHasElements() throws Exception {
        queue.enqueue(messageA);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testCountShouldReturnZeroIfQueueIsEmpty() throws Exception {
        assertEquals(queue.count(), 0);
    }

    @Test
    public void testCountShouldReturnTheNumberOfQueueElements() throws Exception {
        queue.enqueue(messageA);
        queue.enqueue(messageB);

        assertEquals(queue.count(), 2);
    }

    @Test
    public void testPeekShouldReturnNullIfQueueIsEmpty() throws Exception {
        assertNull(queue.peek());
    }

    @Test
    public void testPeekShouldReturnAddedElementWithoutRemovingItFromQueue() throws Exception {
        assertEquals(queue.count(), 0);
        queue.enqueue(messageA);
        assertEquals(queue.count(), 1);

        Message msgFromQueue = queue.peek();

        assertEquals(queue.count(), 1);
        assertEquals(msgFromQueue, messageA);
    }

    @Test
    public void testPeekShouldReturnElementWithTheHighestPriority() throws Exception {
        queue.enqueue(messageC);
        queue.enqueue(messageD);
        queue.enqueue(messageB);

        Message msgFromQueue = queue.peek();

        assertEquals(msgFromQueue, messageB);
    }

    @Test
    public void testPeekShouldReturnElementWithTheHighestPriorityInFIFOOrder() {
        queue.enqueue(messageD);
        queue.enqueue(messageC);

        Message msgFromQueue = queue.peek();

        assertEquals(msgFromQueue, messageD);
    }

    @Test
    public void testEnqueueShouldAddMessageToQueue() {
        assertEquals(queue.count(), 0);

        queue.enqueue(messageA);
        Message msgFromQueue = queue.peek();

        assertEquals(msgFromQueue, messageA);
        assertEquals(queue.count(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testEnqueueShouldThrowExceptionIfMessageIsNull() {
        messageA = null;
        queue.enqueue(messageA);
    }

    @Test
    public void testDequeueShouldReturnNullIfQueueIsEmpty() {
        assertNull(queue.dequeue());
    }

    @Test
    public void testDequeueShouldReturnElementWithTheHighestPriority() {
        queue.enqueue(messageD);
        queue.enqueue(messageC);
        queue.enqueue(messageA);
        queue.enqueue(messageB);

        assertEquals(queue.count(), 4);
        assertEquals(queue.dequeue(), messageA);
        assertEquals(queue.dequeue(), messageB);
        assertEquals(queue.dequeue(), messageD);
        assertEquals(queue.dequeue(), messageC);
        assertEquals(queue.count(), 0);
    }

    @Test
    public void testDequeueShouldReturnElementWithTheSamePriorityInFIFOOrder() {
        Message messageC1 = new Message(Message.InstructionType.C, "Message C1");
        queue.enqueue(messageC1);
        queue.enqueue(messageD);
        queue.enqueue(messageC);

        assertEquals(queue.dequeue(), messageC1);
        assertEquals(queue.dequeue(), messageD);
        assertEquals(queue.dequeue(), messageC);
    }
}