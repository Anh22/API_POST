package com.example.posts.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int likes;
    private Status status;

@ManyToOne
//@JoinColumn(name = "user_id")
private Users users;
    public Users getUsers() {
        return users;
    }

    public Post(Long id, String title, String content, int like, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = like;
        this.status = status;
    }



    public Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return likes;
    }

    public void setLike(int like) {
        this.likes = like;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", like=" + likes +
                ", status='" + status + '\'' +
                '}';
    }
}
