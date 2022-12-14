package com.courses.repository;

import com.courses.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}
