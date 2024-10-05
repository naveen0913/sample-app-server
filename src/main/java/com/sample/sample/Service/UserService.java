package com.sample.sample.Service;

import com.sample.sample.Model.User;
import com.sample.sample.Repository.UserRepo;
import com.sample.sample.Responses.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepo userRepo;

    public ResponseEntity<?> createUser(User user) {

        if (userRepo.findByPhone(user.getPhone()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new AuthResponse(HttpStatus.CONFLICT.value(), "User already exists", null));
        }
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthResponse(HttpStatus.CREATED.value(), "User created successfully", user));
    }

    public ResponseEntity<?> getUserByMobile(String phone){
        Optional<User> existedUser = userRepo.findByPhone(phone);

        if (userRepo.findByPhone(phone).isPresent()){
            return ResponseEntity.ok().body(new AuthResponse(HttpStatus.OK.value(), "available",existedUser));
        }else{
            return ResponseEntity.badRequest().body(new AuthResponse(HttpStatus.NOT_FOUND.value(), "unavailable",null));
        }
    }
}
