package com.rv.projectTestEndpoints.controller;

import com.rv.projectTestEndpoints.entity.User;
import com.rv.projectTestEndpoints.repositories.UserRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainRestControllerTest {

    @LocalServerPort
    Integer localServerPort;

    private static final String LOCAL_HOST = "http://localhost:" ;
    User user = new User(1, "firstName","lastName","Toronto");

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRespository userRespository;

    @BeforeEach
    public void load(){
//        userRespository.deleteAll();
        userRespository.save(user);
    }

    @Test
    public void testAddUserByIdMethod(){

        ResponseEntity<User> responseEntity = this.testRestTemplate.postForEntity(LOCAL_HOST + localServerPort+"/addUser", user, User.class);
        assertThat(((User) Objects.requireNonNull(responseEntity.getBody())).getFirstName()).isEqualTo(user.getFirstName());
    }

    @Test
    public void testGetUsersMethod(){
        List<User> userList =  this.testRestTemplate.getForObject(LOCAL_HOST + localServerPort + "/getUsers", List.class);
        assertThat(userList).isNotNull();
    }

    @Test
    public void testGetUserByIdMethod(){
        int id = 1;
        User actualUser =  this.testRestTemplate.getForObject(LOCAL_HOST + localServerPort + "/findUser/"+id, User.class);
        assertThat(actualUser.getFirstName()).isEqualTo(user.getFirstName());

    }



}
