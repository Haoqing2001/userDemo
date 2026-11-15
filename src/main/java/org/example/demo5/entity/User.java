package org.example.demo5.entity;

import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name="user_1112")
@Entity
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(name="name")
    String name;

    @Column
    String pwd;

    @Column
    int age;

    @Column
    String email;

    @Column
    String phone;

    @Column
    String address;

    @Column
    String nation;

    @Column
    String status;

    @Column
    Date registerDate;
}
