package com.bluedream.springdata.webap1.service;

/**
 * Created by {creator's name}
 */

import com.bluedream.springdata.webap1.model.Role;
import com.bluedream.springdata.webap1.model.Users;
import com.bluedream.springdata.webap1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImplA implements UserService {

    //@Autowired
    //private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Fetch all of user data in the database     *
     *
     * @return
     */
    @Override
    public List<Users> findAll() {
        List<Users> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public String greeting() {
        return ("Good day!");
    }

}
