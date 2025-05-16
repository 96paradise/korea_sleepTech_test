package com.study.korea_sleeptech_test.controller;

import com.study.korea_sleeptech_test.dto.request.PostCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.PostUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Post;
import com.study.korea_sleeptech_test.entity.User;
import com.study.korea_sleeptech_test.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post create(@RequestBody PostCreateRequestDto dto,
                       @AuthenticationPrincipal User user) {
        return postService.createPost(dto, user);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id,
                       @RequestBody PostUpdateRequestDto dto,
                       @AuthenticationPrincipal User user) {
        return postService.updatePost(id, dto, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @AuthenticationPrincipal User user) {
        postService.deletePost(id, user);
    }
}
