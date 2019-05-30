package ru.karamoff.springexamples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.karamoff.springexamples.models.Post;
import ru.karamoff.springexamples.repositories.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByPostedAtDesc();
    }
}
