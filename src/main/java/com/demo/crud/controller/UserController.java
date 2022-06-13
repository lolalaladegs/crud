package com.demo.crud.controller;

import com.demo.crud.dto.MessageResponse;
import com.demo.crud.dto.UserEntity;
import com.demo.crud.model.User;
import com.demo.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        try{
            List<UserEntity> userList = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(userList);
        }catch (CannotCreateTransactionException transactionException) {
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }
    }

    @GetMapping(path = "/{id}", produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id){
        UserEntity userList = new UserEntity();
        try{
            userList = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(userList);
        }catch (CannotCreateTransactionException transactionException) {
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(userList);

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(userList);
        }
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> addUser(@RequestBody UserEntity user){
        try{
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Added new user named "+ user.getName()));
        }catch (CannotCreateTransactionException transactionException) {
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Cannot create user due to" +
                            "Internal Server Error"));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Cannot create user"));
        }
    }

    @PutMapping(path = "/",
            produces =
                    MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> updateUser(@RequestBody UserEntity user){
        try{
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Updates user named "+ user.getName()));
        }catch (CannotCreateTransactionException transactionException) {
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Cannot update user due to" +
                            "Internal Server Error"));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Cannot update user"));
        }
    }

    @DeleteMapping(path = "/{id}",
            produces =
                    MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable int id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Delete user with id "+ id));
        }catch (CannotCreateTransactionException transactionException) {
            log.error(transactionException.getMessage(), transactionException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Cannot update user due to" +
                            "Internal Server Error"));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Cannot update user"));
        }
    }
}
