package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    List<User> userList;

    public List<User> getAllUsers() {
        List<User> response=userRepository.findAll();
        return response;
    }


    public User getUserById(int id) {
       User response=userRepository.findById(id);
        return response;
    }

    public String createUser(CreateUserRequest request) {
        User user=new User();

        user.setId(request.getId());
        user.setName(request.getName());
        user.setAge(request.getAge());

        userRepository.save(user);

        return "ok";
    }

    public String updateUser(int id, UpdateUserRequest request) {
        User user=userRepository.findById(id);
        if(null==user){
            return "fail";
        }

        user.setName(request.getName());
        user.setAge(request.getAge());

        userRepository.save(user);
        return "ok";
    }

    public String deleteUserById(int id) {
        User user =userRepository.findById(id);
        if(null==user){
            return "fail";
        }
        Long count=userRepository.deleteById((id));
        return "ok";
    }


} // Class end
