package com.example.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalculatorMainLv3 {

    public static void main(String[] args) throws IOException {
        final int MAX_MEMORY = 3;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("----- Calculator Lv2 -----");
        System.out.println("MAX_MEMORY: " + MAX_MEMORY);


        CalculatorLv3 calculatorLv3 = new CalculatorLv3();
        boolean cont = true;
        do {
            System.out.print("fist number : ");
            double num1 = Double.parseDouble(bf.readLine());

            System.out.print("operator : ");
            char operator = bf.readLine().charAt(0);

            System.out.print("second number : ");
            double num2 = Double.parseDouble(bf.readLine());


            System.out.printf("%.2f %c %.2f = %.2f%n", num1, operator, num2, calculatorLv3.calculate(num1, num2, operator));

            if (calculatorLv3.getHistory().size() > MAX_MEMORY) {
                calculatorLv3.popHistory();
            }
            System.out.println("hist " + MAX_MEMORY + ": " + calculatorLv3.getHistory());


            System.out.println("if you want to continue:: input any key");
            System.out.println("if you want to clear & continue:: input 'clear'");
            System.out.print("if you want to exit:: input 'exit': ");

            String input = bf.readLine();
            if (input.equals("exit")) {
                cont = false;
            }
            if (input.equals("clear")) {
                calculatorLv3.setHistory(new ArrayList<>());
            }

        } while (cont);
    }
}
