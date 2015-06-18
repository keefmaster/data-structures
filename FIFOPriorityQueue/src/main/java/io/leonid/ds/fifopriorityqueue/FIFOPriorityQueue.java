package io.leonid.ds.fifopriorityqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Leonid Yakubov on 16.06.2015.
 */
public class FIFOPriorityQueue<E extends Comparable<? super E>> {
    PriorityBlockingQueue<FIFOEntry<E>> queue = new PriorityBlockingQueue<FIFOEntry<E>>();

    public void enqueue(E comparable) {
        FIFOEntry<E> entry = (comparable == null) ? null : new FIFOEntry<E>(comparable);

        queue.offer(entry);
    }

    public E dequeue() {
        FIFOEntry<E> entry = queue.poll();

        return entry == null ? null : entry.getEntry();
    }

    public E peek() {
        FIFOEntry<E> entry = queue.peek();

        return entry == null ? null : entry.getEntry();
    }

    public int count() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
