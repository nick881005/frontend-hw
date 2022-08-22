package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> response = userRepository.findAll();
        return response;
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }

//    public List<User> findByAgeGreaterThanEqual(int age) {
//        List<User> userList = userRepository.findByAgeGreaterThanEqual(age);
//        return userList;
//    }

    public String createUser(CreateUserRequest request) {
        User user = new User();
        if (userRepository.findById(request.getId()) != null) {
            return "User already exist";
        }
        user.setId(request.getId());
        user.setName(request.getName());
        user.setAge(request.getAge());
        userRepository.save(user);
        return "OK";
    }

    public String updateUser(int id, UpdateUserRequest request) {
        User user = userRepository.findById(id);
        if (user == null) {
            return "User doesn't exist";
        }
        user.setName(request.getName());
        user.setAge(request.getAge());
        userRepository.save(user);
        return "OK";
    }

    public String deleteUser(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return "User doesn't exist";
        }
        Long count = userRepository.deleteById(id);
        return "OK";
    }

    public List<User> getUserByNameAndAge(String name, int age) {
        List<User> response = userRepository.findByNameAndAge(name, age);
        return response;
    }

    public String createUserBySql(CreateUserRequest request) {
        userRepository.createUserBySql(request.getId(), request.getName(), request.getAge());
        return "OK";
    }

    public String updateUserBySql(int id, UpdateUserRequest request) {
        userRepository.updateUserBySql(request.getAge(), request.getName(), id);
        return "OK";
    }

    public String deleteUser(String name, int age) {
        this.userRepository.DeleteByNameAge(name, age);
        return "delete";


    }

} // Class end
