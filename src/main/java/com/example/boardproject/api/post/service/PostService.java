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

    public Post createPost(PostCreateRequest request) {
        return postRepository.save(Post.createFrom(request));
    }
}
