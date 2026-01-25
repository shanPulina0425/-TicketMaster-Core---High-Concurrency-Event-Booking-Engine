package com.ticketmaster.strategy;

import com.ticketmaster.model.entity.Event;

public interface PriceStrategy {
    double calculatePrice(Event event);
    boolean hasPriority();
}
