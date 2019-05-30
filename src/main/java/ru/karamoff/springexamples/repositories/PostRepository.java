package ru.karamoff.springexamples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.karamoff.springexamples.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * Список постов, отсортированный по дате (по убыванию)
     *
     * @return список постов
     */
    List<Post> findAllByOrderByPostedAtDesc();
}
