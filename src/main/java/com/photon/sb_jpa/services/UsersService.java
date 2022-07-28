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
        Optional<Users> obj = repository.findById(id);      //Serviço, encontrar por id
        return obj.get();
    }

    public Users insert(Users obj){                 //Serviço, inserir o usuário
        return repository.save(obj);
    }

    public void delete(Long id){                //Serviço, deletar o usuário
        repository.deleteById(id);
    }

    public Users update(Long id, Users obj){
        Users entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Users entity, Users obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }
}
