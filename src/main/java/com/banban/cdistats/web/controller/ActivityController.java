package com.banban.cdistats.web.controller;

import com.banban.cdistats.model.Activity;
import com.banban.cdistats.service.ActivityService;
import com.banban.cdistats.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@RestController
public class ActivityController {

    private final ActivityService activityService;

    private final TimeSlotService timeSlotService;

    @Autowired
    public ActivityController(ActivityService activityService, TimeSlotService timeSlotService) {
        this.activityService = activityService;
        this.timeSlotService = timeSlotService;
    }

    @PostMapping("/activity")
    public Activity findByNameAndDayOfWeek() {
        return activityService.save(new Activity()
                .setStudentAmount(25)
                .setDateTime(LocalDateTime.now())
                .setTimeSlot(timeSlotService
                        .findByNameAndDayOfWeek("am_1", DayOfWeek.MONDAY)
                        .orElseThrow(RuntimeException::new)));
    }
}
