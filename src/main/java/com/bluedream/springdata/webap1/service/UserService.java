package com.bluedream.springdata.webap1.service;

import com.bluedream.springdata.webap1.model.Users;

import java.util.List;

public interface UserService {
    public List<Users> findAll() ;

    public String greeting();
}
