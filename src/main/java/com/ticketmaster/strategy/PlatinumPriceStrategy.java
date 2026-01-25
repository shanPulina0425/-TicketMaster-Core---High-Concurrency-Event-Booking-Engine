package com.ticketmaster.strategy;

import com.ticketmaster.model.entity.Event;
import com.ticketmaster.strategy.PriceStrategy;

public class PlatinumPriceStrategy implements PriceStrategy {

    public double calculatePrice(Event event) {
        return event.getBasePrice();
    }

    public boolean hasPriority() {
        return true;
    }
}
