// Savings account: keeps a minimum balance and earns interest
public class SavingsAccount extends Account {

    private double minimumBalance = 100;
    private double interestRate = 0.02;   // 2% per month

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Reject the withdrawal if the balance would drop below the minimum
    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println(accountNumber + ": Withdrawal of " + amount
                    + " rejected, balance cannot go below " + minimumBalance + ".");
        } else {
            balance = balance - amount;
            System.out.println(accountNumber + ": Withdrew " + amount + ". Balance = " + balance);
        }
    }

    // Add interest to the balance
    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance = balance + interest;
        System.out.println(accountNumber + ": Interest added " + interest + ". Balance = " + balance);
    }
}