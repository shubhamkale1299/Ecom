package org.zeroclub.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userservice;



    @GetMapping
    public ResponseEntity<List<User>>  getAllUsers() {
        return new ResponseEntity<>(userservice.fetchAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userservice.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

        @PostMapping()
        public ResponseEntity<String> createUser(@RequestBody User user) {
            userservice.addUser(user);
            return new ResponseEntity<>("user add successfully",HttpStatus.OK) ;
        }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody User updatedUser) {

        boolean updated = userservice.updateUser(id, updatedUser);

        if (updated)
            return ResponseEntity.ok("User updated successfully");

        return ResponseEntity.notFound().build();
    }

    }


