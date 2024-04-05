package com.example.ActsBack.Repository;

import com.example.ActsBack.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <UserModel,Long> {
    Optional<UserModel> findByLogin(String login);
}
