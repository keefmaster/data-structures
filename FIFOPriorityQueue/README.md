FIFOBlockingQueue is a wrapper around the PriorityBlockingQueue, it keeps elements according their priority,
elements with the same priority are stored in First-in-First-out order.
The class supports basic queue operations such as enqueue(), dequeue, peek(), count, isEmpty().

FIFOEntry wrapper is used to keep elements with the equal priority in the FIFO order.

Message is an example class with the following priority rules [Message type (Priority)]:
    A(HIGH) > B(MEDIUM) > C(LOW) == D(LOW)
