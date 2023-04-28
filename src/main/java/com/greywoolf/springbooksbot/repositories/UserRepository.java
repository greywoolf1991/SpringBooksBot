package com.greywoolf.springbooksbot.repositories;

import com.greywoolf.springbooksbot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findUserModelByTgId(String id);
}
