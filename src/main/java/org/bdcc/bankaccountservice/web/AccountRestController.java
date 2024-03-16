package org.bdcc.bankaccountservice.web;

import org.bdcc.bankaccountservice.dto.BankAccountResponseDTO;
import org.bdcc.bankaccountservice.service.AccountService;
import org.bdcc.bankaccountservice.dto.BankAccountRequestDTO;
import org.bdcc.bankaccountservice.exceptions.BankAccountNotFoundException;
import org.bdcc.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestController {
    BankAccountRepository bankAccountRepository;
    AccountService accountService;
    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts") //refactoring done
    public List<BankAccountResponseDTO> bankAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/bankAccounts/{id}")// refactoring done
    public BankAccountResponseDTO bankAccount(@PathVariable String id) throws BankAccountNotFoundException {
        return accountService.getAccountById(id);
    }
    @PostMapping("/bankAccounts") //refactoring done
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }
    @PutMapping("/bankAccounts/{id}")//refactoring done
    public BankAccountResponseDTO updateAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO, @PathVariable String id) throws BankAccountNotFoundException {
        return accountService.updateAccount(bankAccountRequestDTO, id);
    }
    @DeleteMapping("/bankAccounts/{id}")//refactoring done
    public void deleteAccount(@PathVariable String id) throws BankAccountNotFoundException {
        accountService.deleteById(id);
    }
}
