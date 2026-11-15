package org.example.demo5.service;

import lombok.Getter;
import lombok.Setter;

/**
 * wrapper for parameters of users
 */
@Getter
@Setter
public class IdentityParameters {
    String name;

    String pwd;

    int age;

    String email;

    String phone;

    String address;

    String nation;
}
