package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeTranslatorimpl implements AccountTypeTranslator {
    private final AccountTypeRepository  accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorimpl(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDto = new ArrayList<>();
        try{
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDto.add(new AccountTypeDto(accountType));
            }
        }catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDto;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }
}
