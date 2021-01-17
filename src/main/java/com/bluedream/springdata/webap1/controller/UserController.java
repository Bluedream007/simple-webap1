package com.bluedream.springdata.webap1.controller;

import com.bluedream.springdata.webap1.model.Users;
import com.bluedream.springdata.webap1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by {creator's name}
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "brs-application", description = "Operations pertaining to user management in the BRS application")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/All")
    @ApiOperation(value = "Get all of Users data")
    //@ApiOperation(value = {})
    public List<Users> getAllUser() {
        return (userService.findAll());
    }

    @GetMapping(value = "/greeting")
    @ApiOperation(value = "Say greeting!")
    public String greeting() {
        return userService.greeting();
    }

    @GetMapping(value = "/Hello")
    @ApiOperation(value = "Say hello!")
    public String hello() {
        return "Good day!";
    }

}
