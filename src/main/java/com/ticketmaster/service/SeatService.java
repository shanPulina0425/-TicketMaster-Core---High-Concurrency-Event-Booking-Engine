package com.ticketmaster.service;

import com.ticketmaster.exception.SeatLockedException;
import com.ticketmaster.model.entity.Seat;
import com.ticketmaster.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;

@Service
@Transactional
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void holdSeat(Long seatId, Long userId) {

        Seat seat = seatRepository.findSeatForUpdate(seatId);
        LocalDateTime now = LocalDateTime.now();

        if (seat.getStatus() == Seat.SeatStatus.AVAILABLE ||
                (seat.getStatus() == Seat.SeatStatus.HELD &&
                        seat.getHoldExpiry().isBefore(now))) {

            seat.setStatus(Seat.SeatStatus.HELD);
            seat.setHeldByUserId(userId);
            seat.setHoldExpiry(now.plusMinutes(10));

            seatRepository.save(seat);
            return;
        }

        long secondsLeft =
                Duration.between(now, seat.getHoldExpiry()).getSeconds();

        throw new SeatLockedException(
                "Seat locked. Try again in " + secondsLeft + " seconds"
        );
    }
}
