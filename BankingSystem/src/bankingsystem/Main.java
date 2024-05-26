package bankingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. Display Customer Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.println("Choose Account Type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    int accountType = scanner.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Account newAccount = null;
                    if (accountType == 1) {
                        System.out.print("Enter Interest Rate: ");
                        double interestRate = scanner.nextDouble();
                        newAccount = new SavingsAccount(customerId, initialBalance, interestRate);
                    } else if (accountType == 2) {
                        System.out.print("Enter Transaction Fee: ");
                        double transactionFee = scanner.nextDouble();
                        newAccount = new CheckingAccount(customerId, initialBalance, transactionFee);
                    } else {
                        System.out.println("Invalid account type.");
                        break;
                    }
                    Customer newCustomer = new Customer(name, customerId, newAccount);
                    bank.addCustomer(newCustomer);
                    System.out.println("New customer added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextLine();
                    bank.displayCustomerDetails(customerId);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextLine();
                    Customer customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        customer.getAccount().deposit(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextLine();
                    customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        customer.getAccount().withdraw(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Your Customer ID: ");
                    String fromCustomerId = scanner.nextLine();
                    Customer fromCustomer = bank.getCustomer(fromCustomerId);
                    if (fromCustomer != null) {
                        System.out.print("Enter Receiver Customer ID: ");
                        String toCustomerId = scanner.nextLine();
                        Customer toCustomer = bank.getCustomer(toCustomerId);
                        if (toCustomer != null) {
                            System.out.print("Enter amount to transfer: ");
                            double amount = scanner.nextDouble();
                            fromCustomer.getAccount().transfer(toCustomer.getAccount(), amount);
                        } else {
                            System.out.println("Receiver customer not found.");
                        }
                    } else {
                        System.out.println("Sender customer not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextLine();
                    customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        customer.getAccount().calculateInterest();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
