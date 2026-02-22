import java.util.Scanner;
import java.util.ArrayList;

class ATM {
    private double balance = 10000;   // initial balance
    private int pin = 1234;           // default pin
    private ArrayList<String> miniStatement = new ArrayList<>();

    // Verify PIN
    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            miniStatement.add("Deposited: ₹" + amount);
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } 
        else {
            balance -= amount;
            miniStatement.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal Successful!");
        }
    }

    // Mini Statement
    public void showMiniStatement() {
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\n--- Mini Statement ---");
            for (String transaction : miniStatement) {
                System.out.println(transaction);
            }
        }
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("===== WELCOME TO ATM =====");
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN! Access Denied.");
            return;
        }

        System.out.println("Login Successful!");

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    atm.showMiniStatement();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}