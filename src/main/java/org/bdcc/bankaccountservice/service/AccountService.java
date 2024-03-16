package org.bdcc.bankaccountservice.service;

import org.bdcc.bankaccountservice.dto.BankAccountRequestDTO;
import org.bdcc.bankaccountservice.dto.BankAccountResponseDTO;
import org.bdcc.bankaccountservice.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface AccountService {
    BankAccountResponseDTO getAccountById(String id) throws BankAccountNotFoundException;
    BankAccountResponseDTO updateAccount(BankAccountRequestDTO bankAccountRequestDTO, String id) throws BankAccountNotFoundException;
    List<BankAccountResponseDTO> getAllAccounts();
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    void deleteById(String id) throws BankAccountNotFoundException;
    void populateData();

}
