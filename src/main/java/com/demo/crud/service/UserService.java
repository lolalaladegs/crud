package com.demo.crud.service;

import com.demo.crud.dto.UserEntity;
import com.demo.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getUserById(int id);

    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(int id);
}
