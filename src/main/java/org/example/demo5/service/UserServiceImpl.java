package org.example.demo5.service;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.example.demo5.entity.User;
import org.example.demo5.repository.UserRepo;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;

    /**
     * 1. validate input 1.1 if valid passwora
     * 2. check user exists
     * 3. persistence
     *
     * @param identityParameters IdentityParameters wrappers info
     * @return int corresponds different status
     */
    @Override
    public int signup(IdentityParameters identityParameters) {
        String name = identityParameters.getName();
        String pwd = identityParameters.getPwd();
        String email = identityParameters.getEmail();
        String phone = identityParameters.getPhone();

        // step 1: input是否符合基本规定
        // -4
        boolean isUsernameValid = StringUtils.isEmpty(name);
        // -3
        boolean isPwdValid = StringUtils.length(pwd) > 5;
        // -6
        boolean isPhoneValid = StringUtils.isNumeric(phone);
        // -5
        boolean isEmailValid = StringUtils.containsAny(email, "@");

        if (isUsernameValid)
            return -4;

        if (!isPwdValid)
            return -3;

        if (!isPhoneValid)
            return -6;

        if (!isEmailValid)
            return -5;

        // step 2: input是否已经存在
        boolean isSameEmailFound = userRepo.findByEmail(email) != null;
        boolean isSamePhoneFound = userRepo.findByPhone(phone) != null;

        if(isSameEmailFound || isSamePhoneFound)
            return -2;

        User newUser = new User();
        newUser.setName(name);
        newUser.setPwd(pwd);
        newUser.setEmail(email);
        newUser.setPhone(phone);

        userRepo.save(newUser);

        return 0;
    }

    @Override
    public void login(IdentityParameters identityParameters) throws UserException{
        String name = identityParameters.getName();
        String pwd = identityParameters.getPwd();

        boolean isUsernameValid = StringUtils.isAnyBlank(name, pwd);

        if(isUsernameValid){
            throw new UserException.InvalidParameterException("parameter invalid");
        }

        User user = userRepo.findByName(name);
        if(user == null){
            throw new UserException.UserNotFoundException("User " + name + " does not exist");
        }

        if(!pwd.equals(user.getPwd())){
            throw new UserException.InvalidPasswordException("Password do not match");
        }
    }
}

