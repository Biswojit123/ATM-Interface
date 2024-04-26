import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Insufficient balance
    }
}

// ATM class represents the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void handleOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Your current balance is: $" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                boolean success = userAccount.withdraw(withdrawalAmount);
                if (success) {
                    System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance. Withdrawal failed.");
                }
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            atm.handleOption(option);
        }
    }
}

