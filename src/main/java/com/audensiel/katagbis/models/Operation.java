package com.audensiel.katagbis.models;

import com.audensiel.katagbis.models.emun.OperationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author diop
 * @date 21/11/2022
 * class  operation
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Operation {

    private LocalDateTime operationDate;
    private BigDecimal amount;
    private OperationType operationType;
    private BigDecimal balance;

}
