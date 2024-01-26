package com.example.posts.controller;

import com.example.posts.model.Post;
import com.example.posts.model.PostSearch;
import com.example.posts.model.Status;
import com.example.posts.model.Users;
import com.example.posts.repository.PostRepository;
import com.example.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity<>(postRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Post post){
        return new ResponseEntity(postRepository.save(post), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Post post,@PathVariable Long id){
        post.setId(id);
        return new ResponseEntity(postRepository.save(post), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        postRepository.deleteById(id);
        return new ResponseEntity("Delete Done",HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody PostSearch post){
        List<Users> users = userRepository.getUsersByIdIn(post.getUserIds());
        List<Post> postList = postRepository.findAllByUsersInAndStatus(users,post.getStatus());
        return new ResponseEntity<>(postList , HttpStatus.OK);
    }

    @GetMapping("/sortByLikes")
    public ResponseEntity<List<Post>> getPostsSortedByLikes() {
        List<Post> posts = postRepository.findAllOrderByLikesDesc();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/search2")
    public ResponseEntity<?> search2(@RequestBody Status status) {
        List<Post> posts = postRepository.findAllByStatus(status);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/top4ByLikes")
    public ResponseEntity<List<Post>> getTop4PostsByLikes() {
        PageRequest pageable = PageRequest.of(0, 4);
        List<Post> top4Posts = postRepository.findTop4ByOrderByLikesDesc(pageable);
        return new ResponseEntity<>(top4Posts, HttpStatus.OK);
    }




}

