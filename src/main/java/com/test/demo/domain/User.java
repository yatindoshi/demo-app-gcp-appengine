package com.test.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;

    private String name;

    private User(){
    }

    public User(String name) {
        this.name = name;
    }
}
