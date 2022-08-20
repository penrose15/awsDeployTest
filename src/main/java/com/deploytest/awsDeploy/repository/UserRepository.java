package com.deploytest.awsDeploy.repository;

import com.deploytest.awsDeploy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
