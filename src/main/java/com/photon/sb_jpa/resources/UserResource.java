package com.photon.sb_jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.sb_jpa.entities.User;

@RestController
@RequestMapping(value = "/users") //esse recurso irá se chamar users
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@gamil.com","61982434728","123456");
        return ResponseEntity.ok().body(u);
    }
}
