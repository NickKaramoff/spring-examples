package ru.karamoff.springexamples.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // класс-сущность, он будет в БД
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // создастся сиквенс в бд
    private Long id;

    @Column(nullable = false, length = 280) // не null, макс длина 280
    private String text;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") // по умолчанию будет текущие дата-время
    private LocalDateTime postedAt;

    private Long likes;
}
