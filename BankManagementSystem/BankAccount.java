public abstract class BankAccount implements BankOperations {

    private int accountNo;
    private double balance;

    static String BANK_NAME = "Indian Bank";

    final int IFSC = 123456;

    // Constructor 1
    public BankAccount(int accountNo) {
        this.accountNo = accountNo;
        this.balance = 0;
    }

    // Constructor 2
    public BankAccount(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // Getter
    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    // Setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract Method
    public abstract double calculateInterest();

}