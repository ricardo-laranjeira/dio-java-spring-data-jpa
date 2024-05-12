package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //List<User> users = repository.findByNameContaining("Teste");
        List<User> users = repository.filtrarPorNome("Teste");
        for(User u : repository.findAll()){
            System.out.println(u);
        }
    }

    private void insertUser(){
        User user = new User();
        user.setName("UserTeste");
        user.setUsername("user-teste");
        user.setPassword("teste@123");
        repository.save(user);

        for(User u : repository.findAll()){
            System.out.println(u);
        }
    }
}
