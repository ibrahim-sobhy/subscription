package com.subscription.loyalty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoyaltyAPI.class)
public class LoyaltyAPITest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LoyaltyService loyaltyService;

    @Test
    public void whenAddBonusToExistingCustomerThenSuccess() throws Exception {
        String customerId = "1234";
        mvc.perform(get("/loyalty/bonus/"+customerId)
        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void whenAddBonusWithValueToExistingCustomerThenSuccess() throws Exception {
        String customerId = "1234";
        int bonus = 50;
        when(loyaltyService.addBonus(customerId, bonus)).thenReturn(50);
        mvc.perform(get("/loyalty/bonus/"+customerId+"?bonus="+bonus)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bonus", is(bonus)));

        verify(loyaltyService, times(1)).addBonus(customerId, bonus);
        verifyNoMoreInteractions(loyaltyService);
    }

    @Test
    public void whenAddBonusForNonExistingCustomerThenThrowErrorCode() throws Exception {
        String customerId = "0000";
        int bonus = 50;
        when(loyaltyService.addBonus(customerId, bonus)).thenThrow(IllegalArgumentException.class);
        mvc.perform(get("/loyalty/bonus/"+customerId+"?bonus="+bonus)
                    .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Customer is not exist")));

    }


}
