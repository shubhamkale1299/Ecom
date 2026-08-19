package org.zeroclub.ecom.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeroclub.ecom.dto.UserRequest;
import org.zeroclub.ecom.dto.UserResponse;
import org.zeroclub.ecom.model.User;
import org.zeroclub.ecom.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userservice;



    @GetMapping
    public ResponseEntity<List<UserResponse>>  getAllUsers() {
        return new ResponseEntity<>(userservice.fetchAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return userservice.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

        @PostMapping()
        public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
            userservice.addUser(userRequest);
            return new ResponseEntity<>("user add successfully",HttpStatus.OK) ;
        }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody UserRequest updatedUserRequest) {

        boolean updated = userservice.updateUser(id, updatedUserRequest);

        if (updated)
            return ResponseEntity.ok("User updated successfully");

        return ResponseEntity.notFound().build();
    }

    }


