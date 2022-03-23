package com.example.sse5mo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SsE5moApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser
  void demoControllerTest1() throws Exception {

    mockMvc.perform(get("/demo"))
        .andExpect(status().isOk());

  }

  @Test
  void demoControllerTest2() throws Exception {
    mockMvc.perform(get("/demo").with(jwt()))
        .andExpect(status().isOk());

  }

//  @Test
//  void demoControllerTest3() throws Exception {
//    mockMvc.perform(get("/demo").with(httpBasic("", "")))
//        .andExpect(status().isOk());
//
//  }

}
