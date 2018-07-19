package com.xiongqi.securitydemo.web.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author xq
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build() ;
    }

    @Test
    public void whenQuerySuccess() throws Exception {
       String result= mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("name","222")
                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result=  mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
//                .param("name","222")
//                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("tom"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenGetInfoFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
//                .param("name","222")
//                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        System.out.println(date.getTime());
        String content="{\"name\":\"tom\",\"password\":null,\"birthday\":\""+date.getTime() +"\"}";
        String result=mockMvc.perform(MockMvcRequestBuilders.post("/user")
//                .param("name","222")
//                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }


    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date = new Date(LocalDateTime.now().minusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        //System.out.println(date.getTime());
        String content="{\"id\":\"1\",\"name\":\"tom\",\"password\":\"145233\",\"birthday\":\""+date.getTime() +"\"}";
        String result=mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
//                .param("name","222")
//                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }


    @Test
    public void whenDeleteSuccess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
//                .param("name","222")
//                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
