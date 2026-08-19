package org.zeroclub.ecom.dto;

import lombok.Data;
import org.zeroclub.ecom.model.UserRole;



    @Data
    public class UserResponse {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private UserRole role;
        private AddressDTO address;
    }

