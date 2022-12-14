package com.audensiel.katagbis.exception;

import lombok.*;

/**
 * @author diop
 * @date 21/11/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class ExceptionKata extends  RuntimeException{

    private  String message;
}
