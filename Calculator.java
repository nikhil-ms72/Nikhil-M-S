import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SIMPLE CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result = " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Result = " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Result = " + (num1 * num2));
                        break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Result = " + (num1 / num2));
                        } else {
                            System.out.println("Error: Division by zero is not allowed!");
                        }
                        break;
                    case 5:
                        if (num2 != 0) {
                            System.out.println("Result = " + (num1 % num2));
                        } else {
                            System.out.println("Error: Modulus by zero is not allowed!");
                        }
                        break;
                }

            } else if (choice == 6) {
                System.out.println("Exiting Calculator... Thank you!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}