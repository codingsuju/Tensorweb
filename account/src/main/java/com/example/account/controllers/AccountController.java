package com.example.account.controllers;

import com.example.account.models.Profile;
import com.example.account.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    ProfileRepository profileRepository;
    @GetMapping("/api/account/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/api/account/user/{username}/profile")
    public Profile getProfile(@PathVariable String username){
        return profileRepository.findByUsername(username);
    }
    @PostMapping("/api/account/user/{username}/profile")
    public Profile setProfile(@PathVariable String username,Profile profile){
        Profile user_profile=profileRepository.findByUsername(username);
        if(profile==null){
            return user_profile;
        }
        if(user_profile!=null)
          profile.setId(user_profile.getId());
        profile.setUsername(username);
        return profileRepository.save(profile);
    }
    @PutMapping("/api/account/user/{username}/profile")
    public Profile updateProfile(@PathVariable String username,Profile profile){
        Profile user_profile=profileRepository.findByUsername(username);
        if(profile==null){
           return user_profile;
        }
        if(user_profile!=null)
           profile.setId(user_profile.getId());
        profile.setUsername(username);
        return profileRepository.save(profile);
    }
    @GetMapping("/api/account/profiles/init/delete")
    public String delete(){
        profileRepository.deleteAll();
        return "Success";
    }
}
