package com.sample.sample.Controller;

import com.sample.sample.Model.User;
import com.sample.sample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("spring-boot")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("spring-boot/{phone}")
    public ResponseEntity<?> getUserDetails(@PathVariable String phone){
        return userService.getUserByMobile(phone);
    }
}
