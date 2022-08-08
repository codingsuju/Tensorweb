package com.auth.config;
import com.auth.models.AppUser;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);
        //return new User("admin","$2a$10$1vBKG9/27DKC/NBToUPPPevdXcuciv8CyVgWereEIOsMgD5mLk9bK",new ArrayList<>());
    }
}