package com.photon.sb_jpa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<Users> insert(@RequestBody Users obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }



}
