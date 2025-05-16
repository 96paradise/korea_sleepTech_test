package com.study.korea_sleeptech_test.repository;

import com.study.korea_sleeptech_test.entity.Post;
import com.study.korea_sleeptech_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(User author);
}

