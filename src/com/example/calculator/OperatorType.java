package com.example.calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromChar(char opr) {
        for (OperatorType type : values()) {
            if (type.symbol == opr) {
                return type;
            }
        }
        throw new IllegalArgumentException("incorrect operator: " + opr);
    }
}
