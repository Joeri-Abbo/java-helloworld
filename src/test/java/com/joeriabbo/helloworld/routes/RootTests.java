package com.joeriabbo.helloworld.routes;

import com.joeriabbo.helloworld.HelloWorldApplication;
import com.joeriabbo.helloworld.Routes.Root;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class RootTests {

    @InjectMocks
    private Root mainController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
    }

    @Test
    public void testHelloDefaultResponse() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getStatus(), 200);
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello!");
    }
}
