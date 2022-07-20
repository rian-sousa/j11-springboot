package com.photon.sb_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.sb_jpa.entities.Users;
import com.photon.sb_jpa.repositories.UsersRepository;

@Service
public class UsersService {
   
    @Autowired              
    private UsersRepository repository;

    public List<Users> findAll(){
        return repository.findAll();                    //Serviço, encontrar todos, entre database e controllers
    }

    public Users findById(Long id){
        Optional<Users> obj = repository.findById(id);
        return obj.get();
    }

}
