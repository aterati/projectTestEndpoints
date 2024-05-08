package com.rv.projectTestEndpoints.repositories;

import com.rv.projectTestEndpoints.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Integer> {
}
