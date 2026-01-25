package com.ticketmaster.service;

import com.ticketmaster.aop.AuditFailure;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @AuditFailure
    public void bookTicket(Long userId) {
        throw new RuntimeException("Payment failed");
    }
}
