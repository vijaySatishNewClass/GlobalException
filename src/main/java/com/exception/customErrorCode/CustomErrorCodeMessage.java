package com.exception.customErrorCode;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public enum CustomErrorCodeMessage {
    USER_NAME_EXISTS(1001 ,""),
    No_SUCH_USER_EXISTS(1002,""),
    WRONG_PASSWORD(1003,""),
    CONTACT_EXISTS(1004,""),
    EMAILID_NOT_VALID(1005,""),
    EMAILID_EXISTS(1006,""),
    STUDENT_PROFILE_NOT_ACTIVE(1007,"");

    private Integer errorCode;
    private String errorMessage;
}
