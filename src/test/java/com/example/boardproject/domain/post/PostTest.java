package com.example.boardproject.domain.post;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.boardproject.api.post.dto.PostCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    @DisplayName("PostCreateRequest를 post Entity로 변환한다.")
    void postcreaterequestToPostentity() {
        //given
        PostCreateRequest request = new PostCreateRequest("게시물 제목", "게시물 내용");

        //when
        Post post = Post.createFrom(request);

        //then
        assertThat(post.getTitle()).isEqualTo("게시물 제목");
        assertThat(post.getContents()).isEqualTo("게시물 내용");

    }
}