package com.exception.globalCustomException;

import com.exception.model.ErrorMO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomException extends RuntimeException {
    List<ErrorMO> errorMOList;
}

