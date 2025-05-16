package com.study.korea_sleeptech_test.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String role; // "USER" or "ADMIN"
}
