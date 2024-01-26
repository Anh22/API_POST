package com.example.posts.model;

import java.util.List;

public class PostSearch {
    private Status status;
    private List<Long> userIds;

    public PostSearch() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
