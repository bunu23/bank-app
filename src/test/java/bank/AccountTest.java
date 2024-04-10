package bank;

import bank.domain.Account;


import bank.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;


public class AccountTest {
    private Account toAccount, fromAccount;

    @BeforeEach
    public void setup(){
        Customer customer = new Customer("Frank Brown");
        toAccount = new Account();
        toAccount.setCustomer(customer);

        Customer customer2 = new Customer("John Doe");
        fromAccount = new Account();
        fromAccount.setCustomer(customer2);
    }

    @Test
    public void testCreateAccount(){
        assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
    }

    @Test
    public void testDepositZero(){
        toAccount.deposit(0.0);
        assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
    }

    @Test
    public void testDeposit(){
        toAccount.deposit(100.0);
        assertThat( toAccount.getBalance(), closeTo (100.0, 0.01));
    }

    @Test
    public void testWithdrawZero(){
        toAccount.withdraw(0.0);
        assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
    }

    @Test
    public void testWithdraw(){
        toAccount.withdraw(100.0);
        assertThat( toAccount.getBalance(), closeTo (-100.0, 0.01));
    }

    @Test
    public void testTransferFundsZero(){
        fromAccount.transferFunds(toAccount, 0, "for groceries");
        assertThat( fromAccount.getBalance(), closeTo (0.0, 0.01));
        assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
    }

    @Test
    public void testTransferFunds(){
        fromAccount.transferFunds(toAccount, 100, "for groceries");
        assertThat( fromAccount.getBalance(), closeTo (-100.0, 0.01));
        assertThat( toAccount.getBalance(), closeTo (100.0, 0.01));
    }


}
