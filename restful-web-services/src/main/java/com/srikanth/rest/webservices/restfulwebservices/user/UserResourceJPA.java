package com.srikanth.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResourceJPA {
    @Autowired
    UserReposistryJPA userReposistryJPA;

    @Autowired
    PostRepo postRepo;

    @GetMapping("/usersjpa")
    public List<User> getUsers(){
        return userReposistryJPA.findAll();
    }
    @GetMapping("/usersjpa/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        Optional<User> user= userReposistryJPA.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("Id "+id);
        }
        EntityModel model= EntityModel.of(user.get());
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        model.add(link.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/usersjpa/{id}")
    public void delUser(@PathVariable int id){
        userReposistryJPA.deleteById(id);
    }
    @PostMapping("/usersjpa")
    public ResponseEntity<User> createuser(@Valid @RequestBody  User user){
        User userdetails =userReposistryJPA.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userdetails.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/usersjpa/{id}/posts")
    public List<Posts> getAllPosts(@PathVariable int id){
        Optional<User> user= userReposistryJPA.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("Id "+id);
        return user.get().getPost();
    }
    @PostMapping("/usersjpa/{id}/posts")
    public ResponseEntity<User> createuserPosts(@PathVariable int id,@Valid @RequestBody  Posts post){
        Optional<User> user= userReposistryJPA.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("Id "+id);
      post.setUser(user.get());
        Posts savedPost= postRepo.save(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
