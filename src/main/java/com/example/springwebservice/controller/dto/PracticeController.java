package com.example.springwebservice.controller.dto;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/practice")
public class PracticeController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUserList(@RequestParam String name, @RequestParam int age){
        List<User> response = userService.getUserByNameAndAge(name,age);
        return response;
    }
    @PostMapping

    public StatusResponse createUserBySql(@RequestBody CreateUserRequest request){
        String response = userService.createUserBySql(request);
        return new StatusResponse(response);
    }
    @PutMapping("/{id}")
    public StatusResponse updateUserBySql(@PathVariable int id, @RequestBody UpdateUserRequest request){
        String response = userService.updateUserBySql(id, request);
        return new StatusResponse(response);
    }
    @DeleteMapping("/delete")
    public StatusResponse deleteUser(@RequestParam String name, @RequestParam int age){
        String deleteUser = this.userService.deleteUser(name,age);
        return new StatusResponse(deleteUser);
    }

}
