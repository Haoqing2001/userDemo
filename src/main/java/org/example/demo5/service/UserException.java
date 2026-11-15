package org.example.demo5.service;

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    static class UserNotFoundException extends UserException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    static class InvalidPasswordException extends UserException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }

    static class InvalidParameterException extends UserException {
        public InvalidParameterException(String message) {
            super(message);
        }
    }
}
