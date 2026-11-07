public class Main {

    public static void main(String[] args) {

        // Bank Service
        BankService bank = new BankService();

        // Customers
        Customer c1 = new Customer(1, "Akash");

        Customer c2 = new Customer(2, "Ranjith");

        Customer c3 = new Customer(3, "Bharath");

        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        // Create Bank Account
        SavingsAccount account =
                new SavingsAccount(1001, 10000);

        bank.addAccount(account);

        // Display Customers
        System.out.println("BANK: " + BankAccount.BANK_NAME);

        System.out.println("\nCustomer Details:");

        bank.displayCustomers();

        // Polymorphism
        System.out.println(
            "\nInterest: " + account.calculateInterest()
        );

        // Create Threads
        Thread t1 = new Thread(
            new TransactionTask(account, "deposit", 5000),
            "Thread-1"
        );

        Thread t2 = new Thread(
            new TransactionTask(account, "withdraw", 2000),
            "Thread-2"
        );

        Thread t3 = new Thread(
            new TransactionTask(account, "withdraw", 20000),
            "Thread-3"
        );

        // Start Threads
        t1.start();

        t2.start();

        t3.start();

        // Wait for Threads
        try {

            t1.join();

            t2.join();

            t3.join();

        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        // Final Balance
        System.out.println(
            "\nFinal Balance: " + account.getBalance()
        );

        System.out.println("Bank Transaction Completed!");
    }
}