package com.study.korea_sleeptech_test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private String adminUsername;
}

