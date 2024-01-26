package com.example.posts.repository;

import com.example.posts.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {

    List<Users> getUsersByIdIn(List<Long> userIds);
}
