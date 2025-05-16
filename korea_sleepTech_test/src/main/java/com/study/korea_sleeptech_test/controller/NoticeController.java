package com.study.korea_sleeptech_test.controller;

import com.study.korea_sleeptech_test.dto.request.NoticeCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.NoticeUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Notice;
import com.study.korea_sleeptech_test.entity.User;
import com.study.korea_sleeptech_test.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public Notice create(@RequestBody NoticeCreateRequestDto dto,
                         @AuthenticationPrincipal User admin) {
        return noticeService.createNotice(dto, admin);
    }

    @GetMapping
    public List<Notice> getAll() {
        return noticeService.getAllNotices();
    }

    @PutMapping("/{id}")
    public Notice update(@PathVariable Long id,
                         @RequestBody NoticeUpdateRequestDto dto,
                         @AuthenticationPrincipal User admin) {
        return noticeService.updateNotice(id, dto, admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @AuthenticationPrincipal User admin) {
        noticeService.deleteNotice(id, admin);
    }
}
