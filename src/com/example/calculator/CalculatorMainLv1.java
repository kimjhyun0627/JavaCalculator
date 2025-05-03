package com.example.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class CalculatorMainLv1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        System.out.println("----- Calculator Lv1 -----");

        boolean cont = true;
        do {

            System.out.print("fist number : ");
            int num1 = Integer.parseInt(bf.readLine());
            System.out.print("operator : ");
            char operator = bf.readLine().charAt(0);
            System.out.print("second number : ");
            int num2 = Integer.parseInt(bf.readLine());

            switch (operator) {
                case '+':
                    System.out.printf("%d %c %d = %d%n", num1, operator, num2, (num1 + num2));
                    break;
                case '-':
                    System.out.printf("%d %c %d = %d%n", num1, operator, num2, (num1 - num2));
                    break;
                case '*':
                    System.out.printf("%d %c %d = %d%n", num1, operator, num2, (num1 * num2));
                    break;
                case '/':
                    if (num2 == 0) {
                        System.err.println("divide by zero");
                        break;
                    }
                    System.out.printf("%d %c %d = %d%n", num1, operator, num2, (num1 / num2));
                    break;
                default:
                    System.err.println("incorrect operator" + operator);
            }

            System.out.println("if you want to continue, input any key");
            System.out.print("if you want to exit, input 'exit': ");
            String input = bf.readLine();
            if (input.equals("exit")) {
                cont = false;
            }

        } while (cont);
    }
}
