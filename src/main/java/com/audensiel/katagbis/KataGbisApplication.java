package com.audensiel.katagbis;

import com.audensiel.katagbis.models.Account;
import com.audensiel.katagbis.models.Operation;
import com.audensiel.katagbis.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diop
 * @date 21/11/2022
 * class main
 */
@Slf4j
@SpringBootApplication
public class KataGbisApplication {


    public static void main(String[] args) {
        List<Operation> operationsInit = new ArrayList<>();
        Account account = Account.builder().balance(BigDecimal.valueOf(0.0)).firstName("Diop").lastName("Ibrahima").operations(operationsInit).build();

        Operation deposit = OperationService.deposit(account, BigDecimal.valueOf(1000));
        log.info("User stories 1 is =================================> \n {}", deposit);
        Operation withdral = OperationService.withDrawal(account, BigDecimal.valueOf(500));

        log.info("User stories 2 is ==================================>\n {}", withdral);

        List<Operation> operations = OperationService.listOperation(account);

        log.info("User stories 3 the liste of operations==============> {}", operations);


      //  SpringApplication.run(KataGbisApplication.class, args);


    }

}
