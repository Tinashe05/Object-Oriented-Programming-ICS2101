import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        // One list holds both account types
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-1", 1000));
        accounts.add(new CurrentAccount("CUR-1", 200));
        accounts.add(new SavingsAccount("SAV-2", 150));
        accounts.add(new CurrentAccount("CUR-2", 50));

        // Same call for every account, but each type runs its own withdraw()
        System.out.println("--- Withdraw 300 from every account ---");
        for (Account a : accounts) {
            a.withdraw(300);
        }

        // Same call for every account, but each type runs its own endOfMonth()
        System.out.println("\n-- End of month --");
        for (Account a : accounts) {
            a.endOfMonth();
        }

        // Overdraft limit test: CUR-2 is already overdrawn, so this goes too far
        System.out.println("\n-- Extra tests --");
        accounts.get(3).withdraw(300);
        accounts.get(1).deposit(-50);
    }
}