public interface BankOperations {

    void deposit(double amount);

    void deposit(double amount, String description);

    void withdraw(double amount)
            throws InsufficientBalanceException;
}