package com.banban.cdistats.web.controller;

import com.banban.cdistats.model.TimeSlot;
import com.banban.cdistats.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
@CrossOrigin
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    @Autowired
    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/time-slots")
    public TimeSlot findByNameAndDayOfWeek(
            @RequestParam("tsName") String name
    , @RequestParam("tsDayOfWeek")DayOfWeek dayOfWeek) {
        return timeSlotService.findByNameAndDayOfWeek(name, dayOfWeek)
                .orElseThrow(() -> new RuntimeException("Time slot not found with name: " + name +" in day of week :"+dayOfWeek));
    }
}
