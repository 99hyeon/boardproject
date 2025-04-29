package com.example.boardproject.api.post.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.boardproject.domain.post.Post;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시글을 저장한다.")
    void savePost(){
        //given
        Post post = Post.builder()
                .title("게시물 제목")
                .contents("게시물 내용")
                .build();

        //when
        postRepository.save(post);
        List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts).hasSize(1);
        assertThat(posts.get(0).getTitle()).isEqualTo("게시물 제목");
        assertThat(posts.get(0).getContents()).isEqualTo("게시물 내용");
    }


}