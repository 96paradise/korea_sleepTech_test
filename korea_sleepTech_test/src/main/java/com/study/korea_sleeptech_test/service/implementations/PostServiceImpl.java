package com.study.korea_sleeptech_test.service.implementations;

import com.study.korea_sleeptech_test.dto.request.PostCreateRequestDto;
import com.study.korea_sleeptech_test.dto.request.PostUpdateRequestDto;
import com.study.korea_sleeptech_test.entity.Post;
import com.study.korea_sleeptech_test.entity.User;
import com.study.korea_sleeptech_test.repository.PostRepository;
import com.study.korea_sleeptech_test.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post createPost(PostCreateRequestDto dto, User author) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(author)
                .build();

        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, PostUpdateRequestDto dto, User user) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        if (!post.getAuthor().getId().equals(user.getId())) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id, User user) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        if (!post.getAuthor().getId().equals(user.getId())) {
            throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        }

        postRepository.delete(post);
    }
}
