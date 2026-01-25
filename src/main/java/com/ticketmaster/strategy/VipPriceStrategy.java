package com.ticketmaster.strategy;

import com.ticketmaster.model.entity.Event;
import com.ticketmaster.strategy.PriceStrategy;

public class VipPriceStrategy implements PriceStrategy {

    public double calculatePrice(Event event) {
        return event.isHighDemand()
                ? event.getBasePrice()
                : event.getBasePrice() * 0.9;
    }

    public boolean hasPriority() {
        return false;
    }
}
