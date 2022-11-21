package com.audensiel.katagbis.service;

import com.audensiel.katagbis.exception.BalanceInsuffisant;
import com.audensiel.katagbis.models.Account;
import com.audensiel.katagbis.models.Operation;
import com.audensiel.katagbis.models.emun.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diop
 * @date 21/11/2022
 * class Operation service
 *
 */
public class OperationService {


    /**
     *
     * @param account
     * @param amount
     * @return object operation
     */
    public static Operation deposit(Account account, BigDecimal amount) {

        Operation operation = Operation.builder().operationType(OperationType.DEPOSIT).operationDate(LocalDateTime.now()).amount(amount).build();
        account.deposit(amount);
        operation.setBalance(account.getBalance());
        account.addOperation(operation);
        List<Operation> operations= new ArrayList<>();
        operations.add(operation);
        account.setOperations(operations);

        return operation;

    }


    /**
     *
     * @param account
     * @param amount
     * @return object operation
     */
    public static Operation withDrawal(Account account, BigDecimal amount) {

        if(account.getBalance().compareTo(amount)==-1){
                throw new BalanceInsuffisant();
        }

        Operation operation = Operation.builder().operationType(OperationType.WITHDRAW).operationDate(LocalDateTime.now()).amount(amount).build();
        account.withDrawal(amount);
        operation.setBalance(account.getBalance());
        account.addOperation(operation);
        return  operation;
    }


    /**
     *
     * @param account
     * @return all operations
     */
    public static List<Operation> listOperation(Account account) {
        return account.getOperations();
    }
}
