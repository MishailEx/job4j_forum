package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class PostControl {
    private final PostService posts;
    private final MessageService messages;
    private final UserService userService;

    public PostControl(PostService posts, MessageService messages, UserService userService) {
        this.posts = posts;
        this.messages = messages;
        this.userService = userService;
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        if(id != 0) {
            model.addAttribute("post", posts.findById(id));
            model.addAttribute("messages", messages.getAllMessages(id));
            return "post/post";
        }
        return "post/edit";
    }

    @PostMapping("/save")
    public String save(@RequestParam("id") int id, @ModelAttribute Post post) {
        if (id == 0) {
            post.setId(id);
            posts.save(post);
        } else {
            posts.edit(id, post);
            return "redirect:/post?id=" + id;
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "post/edit";
    }

}
