package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorLv3<T extends Number> {

    private List<String> history;

    public CalculatorLv3() {
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

    public double calculate(T num1, T num2, char opr) {
        double operand1 = num1.doubleValue();
        double operand2 = num2.doubleValue();
        OperatorType operator = OperatorType.fromChar(opr);
        double result = switch (operator) {
            case ADD -> operand1 + operand2;
            case SUBTRACT -> operand1 - operand2;
            case MULTIPLY -> operand1 * operand2;
            case DIVIDE -> {
                if (operand2 == 0.0) throw new ArithmeticException("cannot divide by zero");
                yield operand1 / operand2;
            }
        };

        history.add(String.format("%.2f %c %.2f = %.2f", operand1, operator.getSymbol(), operand2, result));
        return result;
    }
}
