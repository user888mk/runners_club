package com.user888mk.web_application.service;

import com.user888mk.web_application.dto.RegistrationDto.RegistrationDto;
import com.user888mk.web_application.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
