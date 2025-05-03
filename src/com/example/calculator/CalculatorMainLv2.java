package com.example.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalculatorMainLv2 {
    public static void main(String[] args) throws IOException {
        final int MAX_MEMORY = 3;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("----- Calculator Lv2 -----");
        System.out.println("MAX_MEMORY: " + MAX_MEMORY);


        Calculator calculator = new Calculator();
        boolean cont = true;
        do {
            System.out.print("fist number : ");
            int num1 = Integer.parseInt(bf.readLine());

            System.out.print("operator : ");
            char operator = bf.readLine().charAt(0);

            System.out.print("second number : ");
            int num2 = Integer.parseInt(bf.readLine());


            System.out.printf("%d %c %d = %d%n", num1, operator, num2, calculator.calculate(num1, num2, operator));

            if (calculator.getHistory().size() > MAX_MEMORY) {
                calculator.popHistory();
            }
            System.out.println("hist " + MAX_MEMORY + ": " + calculator.getHistory());


            System.out.println("if you want to continue:: input any key");
            System.out.println("if you want to clear & continue:: input 'clear'");
            System.out.print("if you want to exit:: input 'exit': ");

            String input = bf.readLine();
            if (input.equals("exit")) {
                cont = false;
            }
            if (input.equals("clear")) {
                calculator.setHistory(new ArrayList<>());
            }

        } while (cont);
    }
}
