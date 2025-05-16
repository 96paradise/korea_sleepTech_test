package com.study.korea_sleeptech_test.repository;

import com.study.korea_sleeptech_test.entity.Notice;
import com.study.korea_sleeptech_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    List<Notice> findByAdmin(User admin);
}

