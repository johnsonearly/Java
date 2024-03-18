package com.example.DatabaseConn.Controllers;

import com.example.DatabaseConn.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,Integer> {
    boolean existsByName(String name);
}
