package com.subscription.loyalty;




import static org.apache.commons.lang3.StringUtils.isNumeric;

public class LoyaltyService {

    private LoyaltyEngine loyaltyEngine;

    public void addBonus(String customerId) {
        validate(customerId);
        int points = loyaltyEngine.add(customerId);
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
