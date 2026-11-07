public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNo, double balance) {
        super(accountNo, balance);
    }

    @Override
    public double calculateInterest() {

        return getBalance() * 4 / 100;
    }

    // Deposit Method 1
    @Override
    public synchronized void deposit(double amount) {

        setBalance(getBalance() + amount);

        System.out.println(
            Thread.currentThread().getName()
            + " Deposit " + amount
            + " - Balance: " + getBalance()
        );
    }

    // Deposit Method 2
    @Override
    public synchronized void deposit(double amount, String description) {

        setBalance(getBalance() + amount);

        System.out.println(
            Thread.currentThread().getName()
            + " Deposit " + amount
            + " (" + description + ")"
            + " - Balance: " + getBalance()
        );
    }

    // Withdraw Method
    @Override
    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > getBalance()) {

            throw new InsufficientBalanceException(
                "Insufficient Balance"
            );
        }

        setBalance(getBalance() - amount);

        System.out.println(
            Thread.currentThread().getName()
            + " Withdraw " + amount
            + " - Balance: " + getBalance()
        );
    }
}