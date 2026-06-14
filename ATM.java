import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Start ATM
    public void start() {
        System.out.println("===================================");
        System.out.println("   WELCOME TO DECODELABS ATM");
        System.out.println("===================================");

        // PIN validation
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3 && !authenticated) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine();

            if (account.validatePin(enteredPin)) {
                authenticated = true;
                System.out.println("\n✅ Access granted. Welcome " + account.getAccountHolderName() + "!\n");
                showMenu();
            } else {
                attempts++;
                System.out.println("❌ Wrong PIN! Attempts left: " + (3 - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("🔒 Too many failed attempts. Card blocked.");
        }

        scanner.close();
    }

    // Main menu
    private void showMenu() {
        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

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
                    System.out.println("👋 Thank you for using DecodeLabs ATM. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please enter 1-4.");
            }
        } while (choice != 4);
    }

    // Balance check
    private void checkBalance() {
        System.out.println("\n💰 Your current balance is: Rs. " + account.getBalance());
    }

    // Deposit
    private void deposit() {
        System.out.print("\nEnter amount to deposit: Rs. ");
        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than zero.");
        } else {
            account.deposit(amount);
        }
    }

    // Withdraw
    private void withdraw() {
        System.out.print("\nEnter amount to withdraw: Rs. ");
        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than zero.");
        } else {
            account.withdraw(amount);
        }
    }

    // Safe integer input
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Invalid input! Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // Safe double input
    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Invalid input! Enter a valid amount: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    // Main method
    public static void main(String[] args) {
        // Create a sample account
        BankAccount userAccount = new BankAccount("Nuwan Perera", "1234", 5000.00);

        // Create and start ATM
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}