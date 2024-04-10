package bank.service;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class AccountDTO {
	private long accountnumber;
	private double balance;
	private Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
	private CustomerDTO customer;

	public AccountDTO() {
	}

	public AccountDTO(long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Collection<AccountEntryDTO> getEntryList() {
		return entryList;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
