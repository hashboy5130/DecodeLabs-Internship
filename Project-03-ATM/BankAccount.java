public class BankAccount {
    private String accountHolderName;
    private String pin;
    private double balance;

    // Constructor
    public BankAccount(String name, String pin, double initialBalance) {
        this.accountHolderName = name;
        this.pin = pin;
        this.balance = initialBalance;
    }

    // check pin is correct or wrong
    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    // Balance check method
    public double getBalance() {
        return balance;
    }

    // Deposit  method
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("✅ Successfully deposited: Rs. " + amount);
            return true;
        } else {
            System.out.println("❌ Invalid deposit amount!");
            return false;
        }
    }

    // Withdraw  method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("✅ Withdrawal successful: Rs. " + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
            return false;
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
            return false;
        }
    }

    // Account holder name   
    public String getAccountHolderName() {
        return accountHolderName;
    }
}
