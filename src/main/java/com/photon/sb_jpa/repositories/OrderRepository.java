package com.photon.sb_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.sb_jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
