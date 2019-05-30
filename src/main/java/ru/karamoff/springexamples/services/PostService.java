package ru.karamoff.springexamples.services;

import ru.karamoff.springexamples.forms.PostForm;
import ru.karamoff.springexamples.models.Post;

import java.util.List;

public interface PostService {
    Post getPost(Long postId);
    List<Post> getAllPosts();
    void createPost(PostForm form);
    List<Post> getAllAnswers(Long postId);
}
