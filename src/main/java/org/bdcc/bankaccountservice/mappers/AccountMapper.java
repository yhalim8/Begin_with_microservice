package org.bdcc.bankaccountservice.mappers;

import org.bdcc.bankaccountservice.entities.BankAccount;
import org.bdcc.bankaccountservice.dto.BankAccountRequestDTO;
import org.bdcc.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountMapper {
    BankAccount formBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO fromBankAccount(BankAccount bankAccount);
}
