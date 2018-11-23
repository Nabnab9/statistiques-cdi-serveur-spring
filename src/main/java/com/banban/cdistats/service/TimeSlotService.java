package com.banban.cdistats.service;

import com.banban.cdistats.model.TimeSlot;
import com.banban.cdistats.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Set<TimeSlot> findByName(String name) {
        return timeSlotRepository.findByName(name);
    }

    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }
}
