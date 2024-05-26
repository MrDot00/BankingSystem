package bankingsystem;

public class CheckingAccount extends Account {
    private double transactionFee;

    public CheckingAccount(String accountNumber, double initialBalance, double transactionFee) {
        super(accountNumber, initialBalance);
        this.transactionFee = transactionFee;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (amount > 0 && amount <= getBalance()) {
            double fee = transactionFee;
            if (getBalance() >= fee) {
                super.withdraw(fee);
                System.out.println("Transaction fee: " + fee);
            } else {
                System.out.println("Insufficient balance for transaction fee.");
            }
        }
    }

    @Override
    public void calculateInterest() {
        // Checking accounts typically don't have interest
        System.out.println("No interest for checking accounts.");
    }
}
