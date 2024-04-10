package bank.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;

@Service
public class BankStatementPrinter {
	
	public void print(Collection<Account> accountlist){
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
		System.out.println("-----------------------------------------------------------------");
		
	}

}
