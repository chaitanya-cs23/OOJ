import java.util.Scanner;

abstract class Account {
    protected String custName;
    protected String acctNumber;
    protected double balance;

    public Account(String custName, String acctNumber) {
        this.custName = custName;
        this.acctNumber = acctNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit must be positive.");
        }
    }

    public abstract void withdraw(double amount);

    public void displayAcctDetails() {
        System.out.println("Customer: " + custName);
        System.out.println("Account Number: " + acctNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavAcc extends Account {
    private double interestRate;

    public SavAcc(String custName, String acctNumber, double interestRate) {
        super(custName, acctNumber);
        this.interestRate = interestRate;
    }

    public void computeInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class CurAcc extends Account {
    private double minimumBalance;
    private double serviceCharge;

    public CurAcc(String custName, String acctNumber, double minimumBalance, double serviceCharge) {
        super(custName, acctNumber);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }

        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge of " + serviceCharge + " applied due to low balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String custName = scanner.nextLine();

        System.out.print("Enter account number: ");
        String acctNumber = scanner.nextLine();

        System.out.print("Enter account type (savings/current): ");
        String accountType = scanner.nextLine();

        Account account = null;

        if (accountType.equalsIgnoreCase("savings")) {
            System.out.print("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavAcc(custName, acctNumber, interestRate);

        } else if (accountType.equalsIgnoreCase("current")) {
            System.out.print("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();
            System.out.print("Enter service charge: ");
            double serviceCharge = scanner.nextDouble();
            account = new CurAcc(custName, acctNumber, minimumBalance, serviceCharge);

        } else {
            System.out.println("Invalid account type.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute interest for Savings Account");
            System.out.println("4. Display account details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    if (account instanceof SavAcc) {
                        ((SavAcc) account).computeInterest();
                    } else {
                        System.out.println("Interest can only be computed for Savings Account.");
                    }
                    break;

                case 4:
                    account.displayAcctDetails();
                    break;

                case 5:
                    System.out.println("K.Chaitanya");
                    System.out.println("USN:1BM23CS144");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
