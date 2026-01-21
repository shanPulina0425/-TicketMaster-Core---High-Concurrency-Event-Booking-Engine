package com.ticketmaster.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "held_by_user_id")
    private Long heldByUserId;

    @Column(name = "hold_expiry")
    private LocalDateTime holdExpiry;

    public enum SeatStatus {
        AVAILABLE, HELD, SOLD
    }


}
