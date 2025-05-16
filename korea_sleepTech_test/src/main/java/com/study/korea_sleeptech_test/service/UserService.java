package com.study.korea_sleeptech_test.service;

import com.study.korea_sleeptech_test.dto.request.LoginRequestDto;
import com.study.korea_sleeptech_test.dto.request.SignupRequestDto;
import com.study.korea_sleeptech_test.entity.User;

public interface UserService {
    void signup(SignupRequestDto dto);
    User login(LoginRequestDto dto);
}
