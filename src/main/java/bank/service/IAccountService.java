package bank.service;

import bank.domain.Account;

import java.util.Collection;


public interface IAccountService {
    public AccountDTO createAccount(long accountNumber, String customerName);
    public AccountDTO getAccount(long accountNumber);
    public Collection<AccountDTO> getAllAccounts();
    public void deposit (long accountNumber, double amount);
    public void withdraw (long accountNumber, double amount);
    public void depositEuros (long accountNumber, double amount);
    public void withdrawEuros (long accountNumber, double amount);
    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
