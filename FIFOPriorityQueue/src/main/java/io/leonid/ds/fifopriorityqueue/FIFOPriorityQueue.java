package io.leonid.ds.fifopriorityqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Leonid Yakubov on 16.06.2015.
 */
public class FIFOPriorityQueue<E extends Comparable<? super E>> {
    PriorityBlockingQueue<FIFOEntry<E>> queue = new PriorityBlockingQueue<FIFOEntry<E>>();

    public void enqueue(E comparable) {
        FIFOEntry<E> entry = new FIFOEntry<E>(comparable);
        queue.offer(entry);
    }

    public E dequeue() {
        return queue.poll().getEntry();
    }

    public E peek() {
        return queue.peek().getEntry();
    }

    public int count() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
