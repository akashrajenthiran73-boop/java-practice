import java.io.FileWriter;
import java.io.IOException;

public class TransactionTask implements Runnable {

    private BankAccount account;

    private String operation;

    private double amount;

    public TransactionTask(
            BankAccount account,
            String operation,
            double amount) {

        this.account = account;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public void run() {

        try {

            if (operation.equalsIgnoreCase("deposit")) {

                account.deposit(amount);

            } else if (operation.equalsIgnoreCase("withdraw")) {

                account.withdraw(amount);
            }

            saveTransaction();

        } catch (InsufficientBalanceException e) {

            System.out.println(
                Thread.currentThread().getName()
                + " Exception: " + e.getMessage()
            );

        } catch (IOException e) {

            System.out.println("File Error: " + e.getMessage());
        }
    }

    private void saveTransaction() throws IOException {

        synchronized (TransactionTask.class) {

            FileWriter writer = new FileWriter(
                "transactions.txt", true
            );

            writer.write(
                Thread.currentThread().getName()
                + " | "
                + operation
                + " | "
                + amount
                + " | Balance: "
                + account.getBalance()
                + "\n"
            );

            writer.close();
        }
    }
}