package com.greywoolf.springbooksbot.helpers;

import com.greywoolf.springbooksbot.models.UserModel;
import com.greywoolf.springbooksbot.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {
    final
    UserRepository userRepository;

    public UserHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
        helper = this;
    }

    private static UserHelper helper = null;

    public static void saveUser(UserModel userModel){
        helper.userRepository.save(userModel);
    }
}
