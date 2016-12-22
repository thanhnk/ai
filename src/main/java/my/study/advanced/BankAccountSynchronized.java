package my.study.advanced;

/**
 * Created by john on 22/12/16.
 */
public class BankAccountSynchronized {
    private long balance;

    public BankAccountSynchronized(long balance) {
        this.balance = balance;
    }

    public synchronized void deposit(long amount) {
        balance += amount;
    }

    public synchronized void withdraw(long amount) {
        balance -= amount;
    }

    public synchronized long getBalance() {
        return balance;
    }
}
