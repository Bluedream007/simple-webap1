package com.bluedream.springdata.webap1.controller;

import com.bluedream.springdata.webap1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest2 {

    @MockBean
    private UserService userService;

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
           // http://localhost:9091/api/v1/user/greeting
           String strURL = "http://localhost:" + port + "/api/v1/user/greeting";
           System.out.println("" + this.restTemplate.getForObject(strURL, String.class));
           //https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5

           /*
           assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/user/greeting",
                String.class)).contains("Good day!");

            */
    }

}
