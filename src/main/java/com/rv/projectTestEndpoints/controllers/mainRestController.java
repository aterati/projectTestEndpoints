package com.rv.projectTestEndpoints.controllers;

import com.rv.projectTestEndpoints.entity.User;
import com.rv.projectTestEndpoints.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class mainRestController {

//    public ResponseEntity<>
    @Autowired
    UserService userService;

    @GetMapping("/findUser/{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id){

        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }


}
