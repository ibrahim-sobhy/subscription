package com.subscription.loyalty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.math.BigDecimal;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyAPI {

    @GetMapping("/bonus/{customerId}")
    public ResponseEntity addBonus(
            @PathVariable("customerId") String customerId,
            @RequestParam(value = "bonus", defaultValue = "10") int bonus) {
        Integer points = 0;

        try {
            points = service.addBonus(customerId,bonus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{'message':'Customer is not exist'}");
        }
        return  ResponseEntity.ok("{'bonus':"+points+"}");
    }

    private LoyaltyService service;

    public LoyaltyAPI(LoyaltyService service) {
        this.service = service;
    }
}
