package ru.karamoff.springexamples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.karamoff.springexamples.models.Post;
import ru.karamoff.springexamples.services.PostService;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String postList(ModelMap map) {
        List<Post> posts = postService.getAllPosts();
        map.addAttribute("posts", posts);
        return "posts";
    }
}
