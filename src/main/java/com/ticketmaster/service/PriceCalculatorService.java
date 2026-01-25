package com.ticketmaster.service;

import com.ticketmaster.model.entity.Event;
import com.ticketmaster.model.entity.User;
import com.ticketmaster.strategy.*;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    public PriceStrategy getStrategy(User user) {

        return switch (user.getTier()) {
            case REGULAR -> new RegularPriceStrategy();
            case VIP -> new VipPriceStrategy();
            case PLATINUM -> new PlatinumPriceStrategy();
        };
    }
}
