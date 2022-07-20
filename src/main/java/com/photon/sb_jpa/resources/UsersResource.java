package com.photon.sb_jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.sb_jpa.entities.Users;
import com.photon.sb_jpa.services.UsersService;

@RestController
@RequestMapping(value = "/users") //esse recurso irá se chamar users
public class UsersResource {

    @Autowired
    private UsersService service;
    
    @GetMapping
    public ResponseEntity<List<Users>> findAll(){
        List<Users> list = service.findAll();
        return ResponseEntity.ok().body(list);      //Endpoint, encontrar todos
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
        Users obj = service.findById(id);
        return ResponseEntity.ok().body(obj);      //Endpoint, encontrar por iD
    }


}
