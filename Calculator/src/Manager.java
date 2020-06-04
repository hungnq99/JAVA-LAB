
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungk
 */
public class Manager {

    static Scanner sc = new Scanner(System.in);

    public static int menu() {

        System.out.println("1. Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputLimit(1, 3);
        return choice;
    }

    public static int checkInputLimit(int min, int max) {
        //Loop until true
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Please input between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input Interger number!!");
                System.out.print("Enter Again: ");
            }

        }
    }

    public static double checkNumberDouble() {
        while (true) {
            try {
                double res = Double.parseDouble(sc.nextLine());
                if(res <= 0){
                    System.out.println("Weight/Height can not smaller than 0!");
                    System.out.println("Enter Again: ");
                }
                else return res;
            } catch (NumberFormatException e) {
                System.out.println("Please input double number");
                System.out.println("Enter Again: ");
            }
        }
    }

    public static double InputNumber() {
        System.out.println("Enter number: ");
        double res = Double.parseDouble(sc.nextLine());
        return res;
    }

    public static String checkOperator() {
        while (true) {
            String operator = sc.nextLine();
            if (operator.isEmpty()) {
                System.out.println("Can not empty!");
                System.out.print("Enter again: ");
            } else if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")
                    || operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")
                    || operator.equalsIgnoreCase("^") || operator.equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.out.println("Please enter [+, -, *, /, ^, =]");
            }
            System.out.print("Enter again: ");
        }
    }

    public static void Calculator() {

        double memory = InputNumber();
        while (true) {
            System.out.println("Enter Operator: ");
            String operator = checkOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += InputNumber();
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("-")) {
                memory -= InputNumber();
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("*")) {
                memory *= InputNumber();
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("/")) {
                memory /= InputNumber();
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, InputNumber());
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public static void BMICalculator() {
        System.out.println("Enter your weight: ");
        double weight = checkNumberDouble();
        System.out.println("Enter your height(cm): ");
        double height = checkNumberDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
