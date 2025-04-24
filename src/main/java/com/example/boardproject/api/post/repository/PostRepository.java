package com.example.boardproject.api.post.repository;

import com.example.boardproject.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
