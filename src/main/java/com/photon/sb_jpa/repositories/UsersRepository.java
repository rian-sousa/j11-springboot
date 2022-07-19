package com.photon.sb_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.sb_jpa.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
