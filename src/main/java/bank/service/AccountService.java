package bank.service;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.AccountChangeEvent;
import bank.domain.Customer;
import bank.integration.jms.IJMSSender;
import bank.logging.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender jmsSender;
	@Autowired
	private ILogger logger;
	@Autowired
	BankStatementPrinter bankStatementPrinter;
	@Autowired
	private ApplicationEventPublisher publisher;



	@Scheduled(cron="*/20 * * * * *")
	public void printBankStatements() {
		bankStatementPrinter.print(accountDAO.findAll());
	}

	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.save(account);
		logger.log("createAccount with parameters accountNumber= "
				+ accountNumber + " , customerName= " + customerName);
		return AccountAdapter.getAccountDTOFromAccount(account);
	}


	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		account.deposit(amount);
		accountDAO.save(account);
		publisher.publishEvent(new AccountChangeEvent("withdraw", accountNumber, amount));
		logger.log("deposit with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountDAO.findById(accountNumber).get();
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accountList = accountDAO.findAll();
		return AccountAdapter.getAccountDTOListFromAccountList(accountList);
	}


	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		account.withdraw(amount);
		accountDAO.save(account);
		publisher.publishEvent(new AccountChangeEvent("withdraw", accountNumber, amount));
		logger.log("withdraw with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
	}


	public void depositEuros(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.save(account);
		publisher.publishEvent(new AccountChangeEvent("deposit", accountNumber, amountDollars));
		logger.log("depositEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
		if (amountDollars > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.save(account);
		publisher.publishEvent(new AccountChangeEvent("withdraw", accountNumber, amountDollars));
		logger.log("withdrawEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber,
							  double amount, String description) {
		Account fromAccount = accountDAO.findById(fromAccountNumber).get();
		Account toAccount = accountDAO.findById(toAccountNumber).get();
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.save(fromAccount);
		accountDAO.save(toAccount);
		publisher.publishEvent(new AccountChangeEvent("transferFunds", fromAccountNumber, toAccountNumber,amount,  description));
		logger.log("transferFunds with parameters fromAccountNumber= "
				+ fromAccountNumber + " , toAccountNumber= " + toAccountNumber
				+ " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("TransferFunds of $ " + amount
					+ " from account with accountNumber= " + fromAccount
					+ " to account with accountNumber= " + toAccount);
		}
	}
}
