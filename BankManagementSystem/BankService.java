import java.util.ArrayList;
import java.util.HashMap;

public class BankService {

    ArrayList<Customer> customers = new ArrayList<>();

    HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public void addCustomer(Customer customer) {

        customers.add(customer);
    }

    public void addAccount(BankAccount account) {

        accounts.put(account.getAccountNo(), account);
    }

    public BankAccount getAccount(int accountNo) {

        return accounts.get(accountNo);
    }

    public void displayCustomers() {

        for (Customer customer : customers) {

            System.out.println(
                customer.getCustomerId()
                + " - "
                + customer.getCustomerName()
            );
        }
    }
}