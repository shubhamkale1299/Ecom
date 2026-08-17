package org.example.ecom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class UserController {

 public List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userList;
    }

        @PostMapping("/api/users")
        public List<User> createUser(@RequestBody User user) {
            userList.add(user);
            return userList;
        }
    }


