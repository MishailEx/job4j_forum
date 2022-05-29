package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findById(int id) {
        return posts.findById(id).get();
    }

    public Post save(Post post) {
        post.setCreated(new Date());
        return posts.save(post);
    }

    public void edit(int id, Post post) {
        Post old = posts.findById(id).get();
        if (!post.getName().isEmpty()) {
            old.setName(post.getName());
        }
        if (!post.getDescription().isEmpty()) {
            old.setDescription(post.getDescription());
        }
        posts.save(old);
    }
}

