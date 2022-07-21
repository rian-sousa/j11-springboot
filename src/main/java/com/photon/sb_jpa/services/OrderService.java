package com.photon.sb_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.sb_jpa.entities.Order;
import com.photon.sb_jpa.repositories.OrderRepository;

@Service
public class OrderService {
   
    @Autowired              
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();                    //Serviço, encontrar todos, entre database e controllers
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
