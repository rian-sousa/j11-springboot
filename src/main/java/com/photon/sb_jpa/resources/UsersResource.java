package com.photon.sb_jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.sb_jpa.entities.Users;

@RestController
@RequestMapping(value = "/users") //esse recurso irá se chamar users
public class UsersResource {
    
    @GetMapping
    public ResponseEntity<Users> findAll(){
        Users u = new Users(1L,"Maria","maria@gamil.com","61982434728","123456");
        return ResponseEntity.ok().body(u);
    }
}
