package org.zeroclub.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeroclub.ecom.dto.UserResponse;
import org.zeroclub.ecom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
