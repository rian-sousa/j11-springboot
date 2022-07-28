package com.photon.sb_jpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.photon.sb_jpa.entities.Users;
import com.photon.sb_jpa.repositories.UsersRepository;
import com.photon.sb_jpa.services.exceptions.DatabaseException;
import com.photon.sb_jpa.services.exceptions.ResourceNotFoundException;

@Service
public class UsersService {
   
    @Autowired              
    private UsersRepository repository;

    public List<Users> findAll(){
        return repository.findAll();                    //Serviço, encontrar todos, entre database e controllers
    }

    public Users findById(Long id){
        Optional<Users> obj = repository.findById(id);      //Serviço, encontrar por id
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Users insert(Users obj){                 //Serviço, inserir o usuário
        return repository.save(obj);
    }

    public void delete(Long id){                //Serviço, deletar o usuário
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        
    }

    public Users update(Long id, Users obj){
        try {
            Users entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Users entity, Users obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }
}
