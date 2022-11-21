package com.audensiel.katagbis;

import com.audensiel.katagbis.exception.BalanceInsuffisant;
import com.audensiel.katagbis.models.Account;
import com.audensiel.katagbis.models.Operation;
import com.audensiel.katagbis.models.emun.OperationType;
import com.audensiel.katagbis.service.OperationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author diop
 * @date 21/11/2022
 */
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class OperationServiceTest {


    @Test
    void shouldDeposit() {

        // Given
        List<Operation> operations = new ArrayList<>();
        Account account = Account.builder().balance(BigDecimal.valueOf(0.0)).firstName("Diop").lastName("Ibrahima").operations(operations).build();

        // Given
        Operation operation = OperationService.deposit(account, BigDecimal.valueOf(1L));

        // Then
        assertNotNull(operation);
    }

    @Test
    void souldwithDrawal() {

        // Given
        List<Operation> operations = new ArrayList<>();
        Account account = Account.builder().balance(BigDecimal.valueOf(2000.0)).firstName("Diop").lastName("Ibrahima").operations(operations).build();

        // Given
        Operation operation = OperationService.withDrawal(account, BigDecimal.valueOf(1L));

        // Then
        assertNotNull(operation);
    }

    @Test
    void souldNnotWithDrawal() {
        // Given
        List<Operation> operations = new ArrayList<>();
        Account account = Account.builder().balance(BigDecimal.valueOf(2000.0)).firstName("Diop").lastName("Ibrahima").operations(operations).build();


        assertThrows(BalanceInsuffisant.class, () -> OperationService.withDrawal(account, BigDecimal.valueOf(50000)));

    }

    @Test
    void souldlistOperation() {

        // Given
        List<Operation> operations = new ArrayList<>();
        Operation operation = Operation.builder().operationType(OperationType.WITHDRAW).operationDate(LocalDateTime.now()).amount(BigDecimal.valueOf(1)).build();

        operations.add(operation);

        Account account = Account.builder().balance(BigDecimal.valueOf(2000.0)).firstName("Diop").lastName("Ibrahima").operations(operations).build();

        // Given
       List<Operation> operationlist= OperationService.listOperation(account);

        // Then
        assertEquals(1, operationlist.size());
    }


}
