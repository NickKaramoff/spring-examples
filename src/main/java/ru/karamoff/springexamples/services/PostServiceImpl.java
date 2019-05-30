package ru.karamoff.springexamples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.karamoff.springexamples.forms.PostForm;
import ru.karamoff.springexamples.models.Post;
import ru.karamoff.springexamples.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPost(Long postId) {
        return postRepository.getOne(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByPostedAtDesc();
    }

    @Override
    public void createPost(PostForm form) {
        Post post = Post.builder()
                .topic(form.getTopic())
                .text(form.getText())
                .likes(0L)
                .postedAt(LocalDateTime.now())
                .build();

        if (form.getParentPostId() != null) {
            Post parentPost = postRepository.getOne(form.getParentPostId());
            post.setParentPost(parentPost);
        }

        postRepository.save(post);
    }

    @Override
    public void likePost(Long postId) {
        Post post = postRepository.getOne(postId);
        post.setLikes(post.getLikes() + 1L);
        postRepository.save(post);
    }
}
