package com.photon.sb_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.sb_jpa.entities.Category;
import com.photon.sb_jpa.repositories.CategoryRepository;

@Service
public class CategoryService {
   
    @Autowired              
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();                    //Serviço, encontrar todos, entre database e controllers
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
