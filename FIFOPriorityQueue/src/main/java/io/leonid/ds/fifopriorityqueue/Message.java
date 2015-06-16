package io.leonid.ds.fifopriorityqueue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leonid Yakubov on 16.06.2015.
 */
public class Message implements Comparable<Message>{
    private InstructionType instructionType;
    private String productCode;

    public Message(InstructionType instructionType, String productCode) {
        super();
        this.instructionType = instructionType;
        this.productCode = productCode;
    }

    public InstructionType getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(InstructionType instructionType) {
        this.instructionType = instructionType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Message [instructionType=" + instructionType + ", productCode="
                + productCode + "]";
    }

    public enum InstructionType {
        A, B, C, D
    }

    public enum InstructionTypePriority {
        HIGH, MEDIUM, LOW
    }

    private static Map<InstructionType, InstructionTypePriority> typePriorities = new HashMap<InstructionType, InstructionTypePriority>();

    static {
        typePriorities.put(InstructionType.A, InstructionTypePriority.HIGH);
        typePriorities.put(InstructionType.B, InstructionTypePriority.MEDIUM);
        typePriorities.put(InstructionType.C, InstructionTypePriority.LOW);
        typePriorities.put(InstructionType.D, InstructionTypePriority.LOW);
    }

    public int compareTo(Message msg) {
        InstructionType type1 = this.getInstructionType();
        InstructionType type2 = msg.getInstructionType();
        InstructionTypePriority priority1 = typePriorities.get(type1);
        InstructionTypePriority priority2 = typePriorities.get(type2);

        return priority1.compareTo(priority2);
    }
}
