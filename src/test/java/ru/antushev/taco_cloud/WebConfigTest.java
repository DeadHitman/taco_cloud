package ru.antushev.taco_cloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import ru.antushev.taco_cloud.tacos.web.WebConfig;

@RunWith(SpringRunner.class)

@WebMvcTest(WebConfig.class) /*Веб-тест для HomeController*/

public class WebConfigTest {


    @Autowired
    private MockMvc mockMvc;       /*Внедряет MockMvc*/

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))              /*Выполняет GET */
                .andExpect(status().isOk())    /*-Ожидает HTTP 200*/
                .andExpect(view().name("home"))    /*Ожидает home*/
                .andExpect((ResultMatcher) content().string( /*Welcome to...*/
                        containsString("Welcome to...")));
    }


}
