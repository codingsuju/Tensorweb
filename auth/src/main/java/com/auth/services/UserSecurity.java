package com.auth.services;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    public boolean hasUsername(String username) {
        String loggedInUsername= SecurityContextHolder.getContext().getAuthentication().getName();
        if(loggedInUsername.equals(username)) return true;
        return false;
    }
}