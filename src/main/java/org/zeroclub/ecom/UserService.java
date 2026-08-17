package org.zeroclub.ecom;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    public List<User> userList = new ArrayList<>();
    private Long nextId =1L;

public List<User> fetchAllUser(){
    return userList;
}

    public List<User> addUser(User user) {
         user.setId(nextId++);
        userList.add(user);
        return userList;
    }

    public Optional<User> fetchUser(Long id) {
        return userList.stream()
                .filter(user -> user.getId()==(id))
                .findFirst();
    }

    public boolean updateUser(Long id, User updatedUser) {
        return userList.stream()
                .filter(user -> user.getId()==(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }

}
