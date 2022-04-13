package com.demo.springprofiles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MessageController {
    @Value("${message}")
    private String message;

    @Value("${testing}")
    private boolean isTesting;

//    @Autowired
//    private Environment env;

    @Value("${spring.profiles.active}")
    private String activeProfiles;


    @GetMapping("/message")
    public String getMessage() {
        getActiveProfiles();
        return message;
    }

    public void getActiveProfiles() {
        for (String profileName : activeProfiles.split(",")) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
