package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.RegService;
import ru.job4j.forum.service.UserService;

import java.util.Date;

@Controller
public class MessageControl {
    private final MessageService messageService;
    private final PostService postService;
    private final UserService userService;

    public MessageControl(MessageService messageService, PostService postService, UserService userService) {
        this.messageService = messageService;
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public String save(@RequestParam("id") int id, @RequestParam("message") String text) {
        Post post = postService.findById(id);
        Message message = new Message(text, RegService.getCurrentUsername(), new Date(), post);
        messageService.saveMess(message);
        return "redirect:/post?id=" + id;
    }
}
