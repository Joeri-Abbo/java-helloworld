package com.joeriabbo.helloworld.routes;

import com.joeriabbo.helloworld.Routes.Hello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class HelloTests {

    @InjectMocks
    private Hello mainController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
    }

    @Test
    public void testHelloDefaultResponse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getStatus(), 200);
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello World!");
    }

    @Test
    public void testHelloEmptyResponse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getStatus(), 200);
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello World!");
    }

    @Test
    public void testHelloJoeriResponse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=joeri")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getStatus(), 200);
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello joeri!");
    }
}
