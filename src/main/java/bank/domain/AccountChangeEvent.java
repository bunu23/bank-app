package bank.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountChangeEvent {
	@Id  
	@GeneratedValue
	private long id;
	private long fromAccountNumber;
	private long toAccountNumber;
	private double amount;
	private String description;
	private long accountNumber;
	private String changeType;
	private Date date = new Date();

	public AccountChangeEvent() {

	}

	public String toString() {
		if (accountNumber != 0L)
			return description + ": accountNumber=" + accountNumber + ", amount=" + amount;
		else
			return description + ": from=" + fromAccountNumber + ", to=" + toAccountNumber + ", amount=" + amount
					+ ", description=" + description;
	}

	public AccountChangeEvent(String changeType, long fromAccountNumber, long toAccountNumber, double amount,
			String description) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.description = description;
		this.changeType = changeType;
	}

	public AccountChangeEvent(String changeType, long accountNumber, double amount) {
		super();
		this.amount = amount;
		this.changeType = changeType;
		this.accountNumber = accountNumber;
	}

}
