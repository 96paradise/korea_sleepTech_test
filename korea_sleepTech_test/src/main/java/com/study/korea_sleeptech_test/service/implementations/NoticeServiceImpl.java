package com.study.korea_sleeptech_test.service.implementations;

import com.study.korea_sleeptech_test.dto.request.NoticeCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.NoticeUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Notice;
import com.study.korea_sleeptech_test.entity.User;
import com.study.korea_sleeptech_test.repository.NoticeRepository;
import com.study.korea_sleeptech_test.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public Notice createNotice(NoticeCreateRequestDto dto, User admin) {
        if (!admin.getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("관리자만 작성 가능합니다.");
        }

        Notice notice = Notice.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .admin(admin)
                .build();

        return noticeRepository.save(notice);
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice updateNotice(Long id, NoticeUpdateRequestDto dto, User admin) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("공지사항이 존재하지 않습니다."));

        if (!notice.getAdmin().getId().equals(admin.getId())) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }

        notice.setTitle(dto.getTitle());
        notice.setContent(dto.getContent());

        return noticeRepository.save(notice);
    }

    @Override
    public void deleteNotice(Long id, User admin) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("공지사항이 존재하지 않습니다."));

        if (!notice.getAdmin().getId().equals(admin.getId())) {
            throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        }

        noticeRepository.delete(notice);
    }
}
