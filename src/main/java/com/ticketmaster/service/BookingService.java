package com.ticketmaster.service;

import com.ticketmaster.aop.AuditFailure;
import org.springframework.stereotype.Service;
import com.ticketmaster.model.entity.User;

@Service
public class BookingService {

    private final PriceCalculatorService priceCalculatorService;

    public BookingService(PriceCalculatorService priceCalculatorService) {
        this.priceCalculatorService = priceCalculatorService;
    }

    @AuditFailure
    public void bookTicket(Long userId) {

        User user = new User();
        user.setTier(User.UserTier.REGULAR);
        priceCalculatorService.getStrategy(user);

        throw new RuntimeException("Payment failed");
    }
}
