package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
    @CrossOrigin
    @Component
    public class StartupDataInit {

        @Autowired
        UtilisateurRepository utilisateurRepository;

        public StartupDataInit(){

        }

        @EventListener(ContextRefreshedEvent.class)
        public void init() {
            
        }
    }
