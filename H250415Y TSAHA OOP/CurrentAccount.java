// Current account: can go into overdraft and pays a monthly fee
public class CurrentAccount extends Account {

    private double overdraftLimit = 500;
    private double monthlyFee = 10;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Allow a negative balance, but not below -overdraftLimit
    @Override
    public void withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println(accountNumber + ": Withdrawal of " + amount
                    + " rejected, overdraft limit is " + overdraftLimit + ".");
        } else {
            balance = balance - amount;
            System.out.println(accountNumber + ": Withdrew " + amount + ". Balance = " + balance);
        }
    }

    // Take the fee off the balance (no interest)
    @Override
    public void endOfMonth() {
        balance = balance - monthlyFee;
        System.out.println(accountNumber + ": Fee charged " + monthlyFee + ". Balance = " + balance);
    }
}