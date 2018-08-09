package com.subscription.loyalty;




import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@Service
public class LoyaltyService {

    private LoyaltyEngine loyaltyEngine;

    public int addBonus(String customerId, int bonus) {
        validate(customerId);
        int points = loyaltyEngine.add(customerId);
        return points;
    }

    public int addBonus(String customerId) {
        return  addBonus(customerId, 10);
    }

    private void validate(String customerId) {
        if(customerId == null)
            throw new IllegalArgumentException();
        if(! isNumeric(customerId)) {
            throw new IllegalArgumentException();
        }
    }

    public void setLoyaltyEngine(LoyaltyEngine loyaltyEngine) {
        this.loyaltyEngine = loyaltyEngine;
    }
}
