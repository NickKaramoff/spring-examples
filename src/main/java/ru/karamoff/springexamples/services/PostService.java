package ru.karamoff.springexamples.services;

import ru.karamoff.springexamples.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
}
