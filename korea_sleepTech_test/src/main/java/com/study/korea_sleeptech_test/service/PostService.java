package com.study.korea_sleeptech_test.service;

import com.study.korea_sleeptech_test.dto.request.PostCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.PostUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Post;
import com.study.korea_sleeptech_test.entity.User;

import java.util.List;

public interface PostService {
    Post createPost(PostCreateRequestDto dto, User author);
    List<Post> getAllPosts();
    Post updatePost(Long id, PostUpdateRequestDto dto, User user);
    void deletePost(Long id, User user);
}
