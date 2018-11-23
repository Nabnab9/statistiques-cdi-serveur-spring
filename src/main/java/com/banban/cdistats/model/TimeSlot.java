package com.banban.cdistats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private LocalTime startTime;

    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @OneToMany(mappedBy = "timeSlot")
    @JsonIgnore
    private Set<Activity> activities;

    public Long getId() {
        return id;
    }

    public TimeSlot setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TimeSlot setName(String name) {
        this.name = name;
        return this;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public TimeSlot setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public TimeSlot setEndTime(LocalTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public TimeSlot setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public TimeSlot setActivities(Set<Activity> activities) {
        this.activities = activities;
        return this;
    }
}
