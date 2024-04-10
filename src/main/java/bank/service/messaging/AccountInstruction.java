package bank.service.messaging;

public class AccountInstruction {
    private long accountNumber;
    private String action;
    private String customerName;
    private double amount;

    public AccountInstruction() {
    }

    public AccountInstruction(long accountNumber, String action, String customerName, double amount) {
        this.accountNumber = accountNumber;
        this.action = action;
        this.customerName = customerName;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAction() {
        return action;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "AccountInstruction{" +
                "accountNumber=" + accountNumber +
                ", action='" + action + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
