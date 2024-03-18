package com.example.DatabaseConn.Controllers;

import com.example.DatabaseConn.Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //get all the users in the database
    @Autowired
    UserRepository repo;


    @GetMapping("/api/v1/users")
    public List<UserEntity> getAllUsers(){
        return repo.findAll();
    }
    @GetMapping("api/v1/user/{id}")
    public UserEntity getUser(@PathVariable int id){
        UserEntity entity = repo.findById(id).get();
            return entity;
    }
    @PostMapping("api/v1/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createUser(@RequestBody UserEntity entity){
    //If statement block
        if (!repo.existsByName(entity.getName())){
            repo.save(entity);
            return "User Created";
        }
        return "NAHHH!!!!!!!!!!!!!!!!!!!!!!!!!!";

    }
    @PutMapping("api/v1/update/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity entity){
        //If statement block

          UserEntity user = repo.findById(id).get();
            user.setName(entity.getName());
            user.setAge(entity.getAge());
            repo.save(user);
            return user;
    }
    @DeleteMapping("api/v1/delete/{id}")
    public String remove_User(@PathVariable int id){
        UserEntity user = repo.findById(id).get();
        repo.delete(user);
        return  "Sucessfully deleted";


    }

}
