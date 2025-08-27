package com.my.jpaTest.repository;

import com.my.jpaTest.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserTestRepositoryTest {
    public interface UserTestRepository extends JpaRepository<UserTest, Long> {

    }
}
