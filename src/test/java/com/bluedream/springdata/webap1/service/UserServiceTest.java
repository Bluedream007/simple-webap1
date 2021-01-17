package com.bluedream.springdata.webap1.service;

import com.bluedream.springdata.webap1.model.Users;
import com.bluedream.springdata.webap1.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Test findAll")
    //@Disabled
    void testFindAll() {
        // Setup our mock repository
        Users user1 = new Users("Test1");
        Users user2 = new Users("Test2");
        doReturn(Arrays.asList(user1, user2)).when(userRepository).findAll();


        // Execute the service call
        List<Users> usersList = userService.findAll();

        // Assert the response
        //Assertions.assertEquals(5, usersList.size(), "findAll should return 5 widgets");
        Assertions.assertEquals(2, usersList.size(), "findAll should return 5 widgets");

        assertThat(usersList).hasSize(2).extracting(Users::getName).contains(user1.getName());

    }


}
