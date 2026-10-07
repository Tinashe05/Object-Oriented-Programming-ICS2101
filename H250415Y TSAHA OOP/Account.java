// Base class that every account type shares
public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Same for all accounts: add money if the amount is positive
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(accountNumber + ": Deposit rejected, amount must be positive.");
        } else {
            balance = balance + amount;
            System.out.println(accountNumber + ": Deposited " + amount + ".New Balance is = " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Each account type writes its own version of these two methods
    public abstract void withdraw(double amount);

    public abstract void endOfMonth();
}