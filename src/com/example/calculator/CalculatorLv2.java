package com.example.calculator;

import java.util.*;

public class CalculatorLv2 {

    private List<String> history;

    public CalculatorLv2() {
        this.history = new ArrayList<>();
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<String> getHistory() {
        return history;
    }

    public void popHistory() {
        history.remove(0);
    }

    public int calculate(int num1, int num2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("cannot divide by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("incorrect operator: " + operator);
        }

        history.add(String.format("%d %c %d = %d", num1, operator, num2, result));

        return result;
    }
}
