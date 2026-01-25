package com.ticketmaster.aop;

import com.ticketmaster.model.entity.AuditLog;
import com.ticketmaster.repository.AuditLogRepository;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditAspect {

    private final AuditLogRepository repo;

    public AuditAspect(AuditLogRepository repo) {
        this.repo = repo;
    }

    @AfterThrowing(pointcut = "@annotation(AuditFailure)", throwing = "ex")
    public void logFailure(Exception ex) {

        AuditLog log = new AuditLog();
        log.setAction("BOOKING_FAILED");
        log.setUserId(1L); // for assignment demo
        log.setDetails(ex.getMessage());
        log.setTimestamp(LocalDateTime.now());

        repo.save(log);
    }
}
