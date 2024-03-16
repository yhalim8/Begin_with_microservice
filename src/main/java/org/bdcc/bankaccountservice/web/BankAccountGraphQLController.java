package org.bdcc.bankaccountservice.web;

import org.bdcc.bankaccountservice.service.AccountService;
import org.bdcc.bankaccountservice.dto.BankAccountRequestDTO;
import org.bdcc.bankaccountservice.dto.BankAccountResponseDTO;
import org.bdcc.bankaccountservice.entities.Customer;
import org.bdcc.bankaccountservice.exceptions.BankAccountNotFoundException;
import org.bdcc.bankaccountservice.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    AccountService accountService;
    CustomerRepository customerRepository;
    public BankAccountGraphQLController(AccountService accountService, CustomerRepository customerRepository) {
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }
    @QueryMapping
    public List<BankAccountResponseDTO> accountList(){
        return accountService.getAllAccounts();
    }
    @QueryMapping
    public BankAccountResponseDTO bankAccountById(@Argument String id) throws BankAccountNotFoundException {
        return accountService.getAccountById(id);
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) throws BankAccountNotFoundException {
        return accountService.updateAccount(bankAccount, id);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) throws BankAccountNotFoundException {
        accountService.deleteById(id);
        return true;
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
