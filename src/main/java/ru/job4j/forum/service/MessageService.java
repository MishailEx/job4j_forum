package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.repository.MessageRepository;
import ru.job4j.forum.repository.PostRepository;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository mesRepository;
    private PostRepository postRepository;

    public MessageService(MessageRepository mesRepository, PostRepository postRepository) {
        this.mesRepository = mesRepository;
        this.postRepository = postRepository;
    }

    public List<Message> getAllMessages(int id) {
        return mesRepository.findAllByPostId(id);
    }

    public void saveMess(Message message) {
        mesRepository.save(message);
    }

    public void deleteMess(int id){
        mesRepository.deleteById(id);
    }
}
