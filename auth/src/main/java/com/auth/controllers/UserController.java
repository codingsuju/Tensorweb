package com.auth.controllers;

import com.auth.models.AppUser;
import com.auth.models.UserResponse;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/api/auth/register")
    public AppUser register(@RequestBody AppUser clientuser){
        if(userRepository.findByUsername(clientuser.getUsername())!=null){
            return new AppUser();
        }
        AppUser user=new AppUser();
        user.setUsername(clientuser.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(clientuser.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }
    @GetMapping("/api/auth/user")
    public Principal user(Principal user){
        return user;
    }
    @GetMapping("/api/auth/init/start")
    public String init(){
        //Create Users
        AppUser u1=new AppUser();
        u1.setRole("ADMIN");
        u1.setUsername("codingsuju");
        u1.setPassword("$2a$10$1vBKG9/27DKC/NBToUPPPevdXcuciv8CyVgWereEIOsMgD5mLk9bK");
        userRepository.save(u1);
        AppUser u2=new AppUser();
        u2.setRole("USER");
        u2.setUsername("suju");
        u2.setPassword("$2a$10$/Khgi0V/csaGDfD.Bn/zfeKhi.u4oA30WO85PYJ8ePKY5um62em1e");
        userRepository.save(u2);
        AppUser u3=new AppUser();
        u3.setRole("USER");
        u3.setUsername("rose");
        u3.setPassword("$2a$10$/Khgi0V/csaGDfD.Bn/zfeKhi.u4oA30WO85PYJ8ePKY5um62em1e");
        userRepository.save(u3);
        AppUser u4=new AppUser();
        u4.setRole("USER");
        u4.setUsername("lisa");
        u4.setPassword("$2a$10$/Khgi0V/csaGDfD.Bn/zfeKhi.u4oA30WO85PYJ8ePKY5um62em1e");
        userRepository.save(u4);
        return "Successfully initialized";
    }
    @GetMapping("/api/auth/init/delete")
    public String delete(){
        userRepository.deleteAll();
        return "Successfully initialized";
    }
    @GetMapping("/api/auth/user/{username}/userinfo")
    public UserResponse username(@PathVariable String username){
        AppUser appUser=userRepository.findByUsername(username);
        return new UserResponse(appUser.getUsername(),appUser.getRole());
    }
}
