package com.banban.cdistats.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Activity {


    public enum ClosingReason {
        CLOSED, STRIKE, OTHER, OPEN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer studentAmount;

    private boolean isSession = false;

    private boolean isSupport = false;

    @Enumerated(EnumType.STRING)
    private ClosingReason closingReason = ClosingReason.OPEN;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    public Long getId() {
        return id;
    }

    public Activity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public Activity setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
        return this;
    }

    public Boolean getSession() {
        return isSession;
    }

    public Activity setSession(Boolean session) {
        isSession = session;
        return this;
    }

    public Boolean getSupport() {
        return isSupport;
    }

    public Activity setSupport(Boolean support) {
        isSupport = support;
        return this;
    }

    public ClosingReason getClosingReason() {
        return closingReason;
    }

    public Activity setClosingReason(ClosingReason closingReason) {
        this.closingReason = closingReason;
        return this;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Activity setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Activity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
