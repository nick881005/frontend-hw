package com.example.springwebservice.controller.dto;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getUserList (@RequestParam(required = false)Integer age) {
        List<User> response = userService.getAllUsers();

        return response;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        return user;
    }


    @PostMapping()
    public StatusResponse createUser(@RequestBody CreateUserRequest request) {
        String response = userService.createUser(request);
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        String response = userService.updateUser(id, request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteUser(@PathVariable int id) {
        String response = userService.deleteUser(id);
        return new StatusResponse(response);
    }

} // Class end
