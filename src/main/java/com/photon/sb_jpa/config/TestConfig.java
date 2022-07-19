package com.photon.sb_jpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.photon.sb_jpa.entities.Users;
import com.photon.sb_jpa.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {

        Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        
        usersRepository.saveAll(Arrays.asList(u1,u2));
    }
    
}
