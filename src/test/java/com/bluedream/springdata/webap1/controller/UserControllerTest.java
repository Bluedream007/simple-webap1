package com.bluedream.springdata.webap1.controller;

import com.bluedream.springdata.webap1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

//  the full Spring application context is started but without the server.
//  We can narrow the tests to only the web layer by using @WebMvcTest
@WebMvcTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;


    @Test
    public void greetingReturnMessageFromMockService() throws Exception {
        when(userService.greeting()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/api/v1/user/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }

        @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
            // TODO: Isolate Unit and Integration Tests
            // https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5
            //MvcResult result =
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/Hello"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Good day!"));

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/Hello")).andReturn();
            assertNotNull(result.getResponse());
            assertEquals("Good day!", result.getResponse().getContentAsString());

/*
            mockMvc.perform(get("/hi/3"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("ok"));
            mockMvc.perform(get("/hi/3/month/4"))
                    .andExpect(status().isNotFound());
 */
    /*
        this.mockMvc.perform(get("/api/v1/user/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Good day!")));

           assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/user/greeting",
                String.class)).contains("Good day!");
*/
    }


}
