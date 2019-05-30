package ru.karamoff.springexamples.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity // класс-сущность, он будет в БД
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // создастся сиквенс в бд
    private Long id;

    @Column(nullable = false, length = 64)
    private String topic;

    @Column(nullable = false, length = 2048) // не null, макс длина 280
    private String text;

    private LocalDateTime postedAt;

    private Long likes;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Post parentPost;

    @OneToMany(mappedBy = "parentPost")
    private List<Post> answers;
}
