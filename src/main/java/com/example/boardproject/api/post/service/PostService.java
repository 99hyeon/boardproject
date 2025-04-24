package com.example.boardproject.api.post.service;

import com.example.boardproject.api.post.dto.PostCreateRequest;
import com.example.boardproject.api.post.repository.PostRepository;
import com.example.boardproject.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostCreateRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .build();

        postRepository.save(post);
    }
}
