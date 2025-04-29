package com.example.boardproject.api.post.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.boardproject.api.post.dto.PostCreateRequest;
import com.example.boardproject.api.post.repository.PostRepository;
import com.example.boardproject.domain.post.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class PostServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Test
    @DisplayName("게시물을 db에 저장 성공했다.")
    void succeedSavePost() {
        //given
        PostCreateRequest request = new PostCreateRequest("제목", "내용");

        //when
        Post post = postService.createPost(request);


        //then
        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContents()).isEqualTo("내용");

    }
}