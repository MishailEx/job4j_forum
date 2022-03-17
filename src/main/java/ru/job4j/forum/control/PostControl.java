package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

public class PostControl {
    @Autowired
    private PostService ps;

    @GetMapping("/post")
    public String post(Model model) {
        return "post/post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        return "/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        return "post/edit";
    }

}
