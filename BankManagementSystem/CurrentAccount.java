public class CurrentAccount extends BankAccount {

    public CurrentAccount(int accountNo, double balance) {
        super(accountNo, balance);
    }

    @Override
    public double calculateInterest() {

        return getBalance() * 2 / 100;
    }

    @Override
    public synchronized void deposit(double amount) {

        setBalance(getBalance() + amount);

        System.out.println(
            Thread.currentThread().getName()
            + " Deposit " + amount
            + " - Balance: " + getBalance()
        );
    }

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