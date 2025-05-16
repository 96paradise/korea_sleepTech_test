package com.study.korea_sleeptech_test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String role;
}

