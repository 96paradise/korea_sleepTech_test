package com.study.korea_sleeptech_test.controller;

import com.study.korea_sleeptech_test.dto.response.UserResponseDto;
import com.study.korea_sleeptech_test.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/me")
    public UserResponseDto getMyInfo(@AuthenticationPrincipal User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getRole());
    }

    @DeleteMapping("/withdraw")
    public String deleteMyAccount(@AuthenticationPrincipal User user) {
        return "회원 탈퇴 완료: " + user.getUsername();
    }
}
