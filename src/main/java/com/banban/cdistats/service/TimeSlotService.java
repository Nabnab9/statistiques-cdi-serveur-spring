package com.banban.cdistats.service;

import com.banban.cdistats.model.TimeSlot;
import com.banban.cdistats.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.Optional;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public Optional<TimeSlot> findByNameAndDayOfWeek(String name, DayOfWeek dayOfWeek) {
        return timeSlotRepository.findByNameAndDayOfWeek(name, dayOfWeek);
    }
}
