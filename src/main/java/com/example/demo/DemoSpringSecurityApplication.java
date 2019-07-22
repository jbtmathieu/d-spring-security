package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSpringSecurityApplication {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

    	  //insertion de 2 utilisateurs en base de données
//        utilisateurRepository.save(new Utilisateur("u1", "pass1", Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
//        utilisateurRepository.save(new Utilisateur("u2",  "pass2", Arrays.asList("ROLE_USER")));
        
        // Chiffrage des mots de passe avant insertion en base de données
        utilisateurRepository.save(new Utilisateur("u1", passwordEncoder.encode("pass1"), Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
        utilisateurRepository.save(new Utilisateur("u2",  passwordEncoder.encode("pass2"), Arrays.asList("ROLE_USER")));

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityApplication.class, args);
    }

}