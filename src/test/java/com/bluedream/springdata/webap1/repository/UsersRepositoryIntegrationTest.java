package com.bluedream.springdata.webap1.repository;

import com.bluedream.springdata.webap1.model.Role;
import com.bluedream.springdata.webap1.model.Users;
import org.h2.engine.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class) //匯入spring測試框架[2]
//@SpringBootTest  // already includes the @ExtendWith(SpringExtension.class) annotation
@DataJpaTest
public class UsersRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Change the name and findAll")
    public void givenSetOfUsers_whenFindAll_thenReturnAllUsers() {

        Users usersTom2 = userRepository.findByName("Tom");
        usersTom2.setName("Tom2");
        Users updatedUsers = userRepository.save(usersTom2);

        Assertions.assertNotNull(updatedUsers, "The saved Users should not be null");

        List<Users> usersList = userRepository.findAll();
        for(Users item : usersList) {
            Set<Role> roleSet = item.getRoles();
            for(Role roles: roleSet) {
                System.out.println("Users: " +item.getId()+"-"+item.getName());
                System.out.println("roles: " +roles.getId()+"-"+roles.getName());
            }
        }

       assertThat(usersList).hasSize(3).extracting(Users::getName).contains(usersTom2.getName());

    }

}
