package ru.karamoff.springexamples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karamoff.springexamples.forms.PostForm;
import ru.karamoff.springexamples.services.PostService;

@Controller
public class ComposeController {

    @Autowired
    private PostService postService;

    @GetMapping("/compose")
    public String composePage() {
        return "compose";
    }

    @GetMapping("/compose/{parentId}")
    public String composeAnswerPage(@PathVariable Long parentId, ModelMap map) {
        map.addAttribute("parent", parentId);
        return "compose";
    }

    @PostMapping("/compose")
    public String composePostAction(PostForm form) {
        postService.createPost(form);
        return "redirect:posts";
    }
}
