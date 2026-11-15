package org.example.demo5.controller;

import jakarta.annotation.Resource;
import org.example.demo5.service.IdentityParameters;
import org.example.demo5.service.UserException;
import org.example.demo5.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(path = "/user/signup")
    public String signup(@RequestParam("name") String name, @RequestParam("password") String password,
                         @RequestParam("phone") String phone, @RequestParam("email") String email) {
        String result = null;
        IdentityParameters identityParameters = new IdentityParameters();
        identityParameters.setName(name);
        identityParameters.setPwd(password);
        identityParameters.setPhone(phone);
        identityParameters.setEmail(email);

        int signupCode = userService.signup(identityParameters);
        switch(signupCode) {
            case 0:
                result = "success";
                break;
            case -1:
                result = "param error";
                break;
            case -2:
                result = "user exists";
                break;
            case -3:
                result = "password is not valid";
                break;
            case -4:
                result = "name is not valid";
                break;
            case -5:
                result = "email is not valid";
                break;
            case -6:
                result = "phone is not valid";
                break;
        }
        return result;
    }

    @PostMapping(path="/user/login")
    public Resp login(@RequestParam("name") String name, @RequestParam("password") String password) {
        String result = null;
        try{
            userService.login(new IdentityParameters());
            result = "success";
        } catch (UserException userException) {
            userException.printStackTrace();
            result = "fail";
        }
        return Resp.newInstance(0, result);

    }


}
