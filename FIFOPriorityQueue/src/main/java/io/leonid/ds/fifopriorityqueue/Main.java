package io.leonid.ds.fifopriorityqueue;

import io.leonid.ds.fifopriorityqueue.Message.InstructionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid Yakubov on 16.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message(InstructionType.B, "M1"));
        messages.add(new Message(InstructionType.A, "M2"));
        messages.add(new Message(InstructionType.A, "M3"));
        messages.add(new Message(InstructionType.C, "M4"));
        messages.add(new Message(InstructionType.D, "M5"));
        messages.add(new Message(InstructionType.C, "M6"));

        FIFOPriorityQueue<Message> queue = new FIFOPriorityQueue<Message>();

        for (Message msg : messages) {
            queue.enqueue(msg);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
