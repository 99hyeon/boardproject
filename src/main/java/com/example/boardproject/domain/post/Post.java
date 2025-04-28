package com.example.boardproject.domain.post;

import com.example.boardproject.api.post.dto.PostCreateRequest;
import com.example.boardproject.domain.comment.Comment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static Post createFrom(PostCreateRequest request){
        return Post.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .build();
    }
}
