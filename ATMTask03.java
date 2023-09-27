import java.util.Scanner;

public class ATMTask03 {
    private double balance;
    private Scanner scanner;

    public ATMTask03(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM");
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private void deposit() {
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        ATMTask03 atm = new ATMTask03(1000.0); // Initialize with an initial balance
        atm.start();
    }
}
