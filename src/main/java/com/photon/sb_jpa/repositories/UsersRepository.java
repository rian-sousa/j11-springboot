package com.photon.sb_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.sb_jpa.entities.Users;

//@Repository       Não é necessário nesse caso, pq a interface já esta´herdando JPArepository que já é registrado.
public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
