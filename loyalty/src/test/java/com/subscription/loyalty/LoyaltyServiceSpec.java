package com.subscription.loyalty;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class LoyaltyServiceSpec {

    private LoyaltyService loyaltyService;


    public LoyaltyEngine loyaltyEngine;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        loyaltyEngine = mock(LoyaltyEngine.class);
        loyaltyService = new LoyaltyService();
        loyaltyService.setLoyaltyEngine(loyaltyEngine);
    }

    @Test
    public void whenCallAddByNullCustomerThrowInvalidArgumentException() {
        exception.expect(IllegalArgumentException.class);
        loyaltyService.addBonus(null);
    }

    @Test
    public void whenCustomerIdHasCharactersThrowInvalidArgumentException() {
        exception.expect(IllegalArgumentException.class);
        String customerId = "123EEE";
        loyaltyService.addBonus(customerId);
    }

    @Test
    public void whenCustomerIdHasDigitsOnlyThenPassed() {
        String customerId = "123";
        loyaltyService.addBonus(customerId);
    }

    @Test
    public void whenAddBonusToCustomerThenLoyaltyEngine10Points() {
        String customerId = "123";
        when(loyaltyEngine.add(customerId)).thenReturn(10);
        loyaltyService.addBonus(customerId);
        verify(loyaltyEngine,atMost(1)).add(customerId);
    }

}
