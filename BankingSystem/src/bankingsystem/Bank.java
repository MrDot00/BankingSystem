package bankingsystem;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public void displayCustomerDetails(String customerId) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Account Number: " + customer.getAccount().getAccountNumber());
            System.out.println("Account Balance: " + customer.getAccount().getBalance());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
