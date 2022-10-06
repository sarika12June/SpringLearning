package com.srikanth.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;


import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userDAOService.getUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user= userDAOService.findOne(id);
        if(user==null){
            throw new UserNotFoundException("Id "+id);
        }
        EntityModel model= EntityModel.of(user);
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        model.add(link.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/users/{id}")
    public void delUser(@PathVariable int id){
        userDAOService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createuser(@Valid  @RequestBody  User user){
        User userdetails =userDAOService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userdetails.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

}
