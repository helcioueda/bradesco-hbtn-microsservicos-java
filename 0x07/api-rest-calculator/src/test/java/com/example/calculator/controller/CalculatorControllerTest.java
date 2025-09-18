package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        mvc.perform(get("/calculator/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bem vindo à CALCULATOR API REST.")));
    }

    @Test
    void addNumbers() throws Exception {
        mvc.perform(get("/calculator/addNumbers")
                        .param("number1", "5.0")
                        .param("number2", "5.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }

    @Test
    void subNumbers() throws Exception {
        mvc.perform(get("/calculator/subNumbers")
                        .param("number1", "10.0")
                        .param("number2", "5.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void divideNumbers() throws Exception {
        mvc.perform(get("/calculator/divideNumbers")
                        .param("number1", "10.0")
                        .param("number2", "2.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void divisionByZero() throws Exception {
        mvc.perform(get("/calculator/divideNumbers")
                        .param("number1", "10.0")
                        .param("number2", "0.0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void factorial() throws Exception {
        mvc.perform(get("/calculator/factorial")
                        .param("factorial", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        mvc.perform(get("/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15")
                        .param("localDate2", "2020-03-29"))
                .andExpect(status().isOk())
                .andExpect(content().string("14"));
    }

    @Test
    void integerToBinary() throws Exception {
        mvc.perform(get("/calculator/integerToBinary")
                        .param("number1", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("10100"));
    }

    @Test
    void integerToHexadecimal() throws Exception {
        mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "170"))
                .andExpect(status().isOk())
                .andExpect(content().string("aa"));
    }
}