package com.study.korea_sleeptech_test.service;

import com.study.korea_sleeptech_test.dto.request.NoticeCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.NoticeUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Notice;
import com.study.korea_sleeptech_test.entity.User;

import java.util.List;

public interface NoticeService {
    Notice createNotice(NoticeCreateRequestDto dto, User admin);
    List<Notice> getAllNotices();
    Notice updateNotice(Long id, NoticeUpdateRequestDto dto, User admin);
    void deleteNotice(Long id, User admin);
}
