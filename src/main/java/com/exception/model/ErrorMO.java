package com.exception.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorMO {
private Integer errorCode;
private String errorMessage;
}
