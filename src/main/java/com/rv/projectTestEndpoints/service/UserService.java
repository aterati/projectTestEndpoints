package com.rv.projectTestEndpoints.service;

import com.rv.projectTestEndpoints.entity.User;
import com.rv.projectTestEndpoints.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRespository userRespository;

    public User getUser(Integer id){

        return  userRespository.findById(id).get();
    }

    public List<User> getUsers(){

        return userRespository.findAll();
    }

    public User addUser(User user){

        return userRespository.save(user);
    }


}
