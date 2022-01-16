package com.sumit.Spring.Security.Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  // method to load the data based on username

  User findByUsername(String username);
}
