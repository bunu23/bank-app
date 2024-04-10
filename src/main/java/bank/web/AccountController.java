package bank.web;

import bank.service.AccountDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestParam(value= "accountNumber") long accountNumber,
                                           @RequestParam(value= "customerName") String customerName) {
        AccountDTO accountDto = accountService.createAccount(accountNumber, customerName);
        return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public AccountDTO accountOperation (
            @RequestParam(value= "accountNumber")long accountNumber,
            @RequestParam(value= "amount")double amount,
            @RequestParam(value= "operation") String operation,
            @RequestParam(value= "toAccountNumber")long toAccountNumber,
            @RequestParam(value= "description")String description) {
        if (operation. equals("deposit")) accountService.deposit(accountNumber, amount );
        if (operation. equals("depositEuros")) accountService.depositEuros(accountNumber, amount );
        if (operation. equals("withdraw")) accountService.withdraw(accountNumber, amount );
        if (operation. equals("withdrawEuros")) accountService.withdrawEuros(accountNumber, amount );
        if (operation. equals("transferFunds")) accountService.transferFunds(accountNumber, toAccountNumber, amount, description);
        return accountService.getAccount(accountNumber);
    }
    @GetMapping ("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable("accountNumber") long accountNumber){
        AccountDTO accountDto = accountService.getAccount(accountNumber);
        return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
    }

    @GetMapping ("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        Collection<AccountDTO>  accountList = accountService.getAllAccounts();
        Accounts accounts = new Accounts();
        accounts.setAccountList(accountList);
        return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
    }

}

