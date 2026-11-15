package org.example.demo5;

import org.example.demo5.repository.UserRepo;
import org.example.demo5.service.IdentityParameters;
import org.example.demo5.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceImplTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testEmptyUserByUsername() {
        IdentityParameters parameters = new IdentityParameters();
        parameters.setName("Emma");
        parameters.setPwd("123456");
        parameters.setPhone("801321321");
        parameters.setEmail("12345@gmail.com");
        int result = userService.signup(parameters);
    }
}
