package com.example.posts.controller;

import com.example.posts.model.Users;
import com.example.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Users users){
        return new ResponseEntity(userRepository.save(users), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Users users,@PathVariable Long id){
        users.setId(id);
        return new ResponseEntity(userRepository.save(users), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity("Delete Done",HttpStatus.OK);
    }
}
