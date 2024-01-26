package com.example.posts.repository;

import com.example.posts.model.Post;
import com.example.posts.model.Status;
import com.example.posts.model.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
//    List<Post> findAllByUsersInAndStatus(Collection<Users> users, String status);
    @Query("SELECT p FROM Post p ORDER BY p.likes DESC")
    List<Post> findAllOrderByLikesDesc();
    List<Post> findAllByStatus(Status status);

    @Query("SELECT p FROM Post p ORDER BY p.likes DESC")
    List<Post> findTop4ByOrderByLikesDesc(Pageable pageable);
    List<Post> findAllByUsersInAndStatus(List<Users> users, Status status);


}
