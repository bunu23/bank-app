package bank.service;

import bank.domain.AccountEntry;
import bank.domain.Customer;

public class AccountEntryAdapter {
    public static AccountEntry getAccountEntryFromAccountEntryDTO(AccountEntryDTO accountEntryDto){
        AccountEntry accountEntry = new AccountEntry();
        accountEntry.setDate(accountEntryDto.getDate());
        accountEntry.setAmount(accountEntryDto.getAmount());
        accountEntry.setDescription(accountEntryDto.getDescription());
        accountEntry.setFromAccountNumber(accountEntryDto.getFromAccountNumber());
        accountEntry.setFromPersonName(accountEntryDto.getFromPersonName());
        return accountEntry;
    }
    public static AccountEntryDTO getAccountEntryDTOFromAccountEntry(AccountEntry accountEntry){
        AccountEntryDTO accountEntryDto = new AccountEntryDTO();
        accountEntryDto.setDate(accountEntry.getDate());
        accountEntryDto.setAmount(accountEntry.getAmount());
        accountEntryDto.setDescription(accountEntry.getDescription());
        accountEntryDto.setFromAccountNumber(accountEntry.getFromAccountNumber());
        accountEntryDto.setFromPersonName(accountEntry.getFromPersonName());
        return accountEntryDto;
    }
}
