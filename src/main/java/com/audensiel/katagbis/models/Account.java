package com.audensiel.katagbis.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diop
 * @date 21/11/2022
 * class Account
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Account {
    private BigDecimal balance;
    private String lastName;
    private String firstName;
    List<Operation> operations = new ArrayList<>();

    /**
     *
     * @param operation
     *
     */
    public void addOperation(Operation operation){
        this.operations.add(operation);
    }

    /**
     *
     * @param value
     * return
     */
    public void deposit(BigDecimal value){
    this.balance = this.balance.add(value);
    }

    /**
     *
     * @param value
     *
     */
    public void withDrawal(BigDecimal value){
        this.balance = this.balance.subtract(value);
    }

}
