package org.example.demo5.service;

import jdk.jshell.spi.ExecutionControl;

public interface UserService {

    /**
     * honor option1
     * return code desc:
     * 0: success;
     * -1: input error;
     * -2: user exists;
     * -3: password not valid;
     *
     * @param identityParameters
     * @return
     */
    int signup(IdentityParameters identityParameters);

    /**
     * honor option2
     * it's better Frontend ensure that the parameters are not empty
     *
     * @param identityParameters
     * @throws ExecutionControl.UserException
     */
    void login(IdentityParameters identityParameters) throws UserException;

}

