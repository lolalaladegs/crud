package com.demo.crud.service.implementation;

import com.demo.crud.dto.UserEntity;
import com.demo.crud.model.User;
import com.demo.crud.repository.UserRepository;
import com.demo.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers(){
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserById(int id){
        UserEntity user = userRepository.getUserById(id);
        return user;
    }

    @Override
    public void addUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
