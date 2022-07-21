package com.photon.sb_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.sb_jpa.entities.Product;
import com.photon.sb_jpa.repositories.ProductRepository;

@Service
public class ProductService {
   
    @Autowired              
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();                    //Serviço, encontrar todos, entre database e controllers
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
