/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.relay.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.relay.pojo.TomatoSale;
import com.relay.service.TomatoSalesService;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TomatoSalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TomatoSalesService service;

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        final Integer requestedSize = 10;
        final Collection<TomatoSale> resultFromService = getMockedCollectionOfTomatoSales(requestedSize);

        given(service.queryLatestTomatoSales(requestedSize)).willReturn(resultFromService);

        this.mockMvc.perform(get("/tomatosale").param("size", requestedSize.toString())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(requestedSize)));
    }

    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        final int defaultValue = new Integer(TomatoSalesController.DEFAULT_VALUE);
        final Collection<TomatoSale> resultFromService = getMockedCollectionOfTomatoSales(defaultValue);

        given(service.queryLatestTomatoSales(defaultValue)).willReturn(resultFromService);

        mockMvc.perform(get("/tomatosale")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(defaultValue)));
    }

    private Collection<TomatoSale> getMockedCollectionOfTomatoSales(int size) {

        final Collection<TomatoSale> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final TomatoSale tomatoSale = TomatoSale.builder().build();
            result.add(tomatoSale);
        }
        return result;
    }

}
