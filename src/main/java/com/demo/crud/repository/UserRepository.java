package com.demo.crud.repository;

import com.demo.crud.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(name = "User.getUserById", nativeQuery = true)
    UserEntity getUserById(@Param("id") int id);
}
