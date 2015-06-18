package io.leonid.ds.fifopriorityqueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Leonid Yakubov on 18.06.2015.
 */
public class FIFOEntryTest {
    private Message defaultMessage;
    private FIFOEntry<Message> defaultEntry;

    @Before
    public void setUp() throws Exception {
        defaultMessage = new Message(Message.InstructionType.B, "defaultMessage");
        defaultEntry = new FIFOEntry<Message>(defaultMessage);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetEntryShouldIncrementSequenceNumber() throws Exception {
        long seqNum = defaultEntry.getSeqNum();
        Message messageB = new Message(Message.InstructionType.B, "Message B");
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(messageB);

        assertEquals(seqNum, entry1.getSeqNum() -1);
    }

    @Test (expected = NullPointerException.class)
    public void testCompareToShouldThrowNPEIfTheOneEntryIsNull() throws Exception {
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(null);
        defaultEntry.compareTo(entry1);
    }

    @Test
    public void testCompareToShouldReturnMinusOneIfTheFirstEntryHasALowerPriority() throws Exception {
        Message messageC = new Message(Message.InstructionType.C, "Message C");
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(messageC);

        assertEquals(defaultEntry.compareTo(entry1), -1);
    }

    @Test
    public void testCompareToShouldReturnOneIfTheFirstEntryHasAHigherPriority() throws Exception {
        Message messageA = new Message(Message.InstructionType.A, "Message A");
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(messageA);

        assertEquals(defaultEntry.compareTo(entry1), 1);
    }

    @Test
    public void testCompareToShouldReturnZeroIfEntriesAreTheSame() throws Exception {
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(defaultMessage);

        assertEquals(defaultEntry.compareTo(entry1), 0);
    }

    @Test
    public void testCompareToShouldReturnMinusOneIfTheFirstEntryWasInsertedBeforeTheSecondOne() throws Exception {
        Message messageB = new Message(Message.InstructionType.B, "Message B");
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(messageB);

        assertEquals(defaultEntry.compareTo(entry1), -1);
    }

    @Test
    public void testCompareToShouldReturnOneIfTheFirstEntryWasInsertedAfterTheSecondOne() throws Exception {
        Message messageD = new Message(Message.InstructionType.D, "Message D");
        FIFOEntry<Message> entry2 = new FIFOEntry<Message>(messageD);
        Message messageC = new Message(Message.InstructionType.C, "Message C");
        FIFOEntry<Message> entry1 = new FIFOEntry<Message>(messageC);

        assertEquals(entry1.compareTo(entry2), 1);
    }
}