package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String userName;
    private Date created;
    @OneToOne
    private Post post;

    public Message() {
    }

    public Message(String text, String userName, Date created, Post post) {
        this.text = text;
        this.userName = userName;
        this.created = created;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && Objects.equals(text, message.text) && Objects.equals(userName, message.userName) && Objects.equals(created, message.created) && Objects.equals(post, message.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, userName, created, post);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                ", created=" + created +
                ", post=" + post +
                '}';
    }
}
