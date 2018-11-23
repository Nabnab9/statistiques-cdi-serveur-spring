package com.banban.cdistats.web.controller;

import com.banban.cdistats.model.Activity;
import com.banban.cdistats.model.TimeSlot;
import com.banban.cdistats.service.ActivityService;
import com.banban.cdistats.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class ActivityController {

    private final ActivityService activityService;

    private final TimeSlotService timeSlotService;

    @Autowired
    public ActivityController(ActivityService activityService, TimeSlotService timeSlotService) {
        this.activityService = activityService;
        this.timeSlotService = timeSlotService;
    }

    @PostMapping("/activity")
    public Activity saveActivity(@RequestBody Activity a) {
        TimeSlot ts = timeSlotService.findByNameAndDayOfWeek(a.getTimeSlot().getName(), a.getTimeSlot().getDayOfWeek()).orElseThrow(EntityNotFoundException::new);
        a.setTimeSlot(ts);
        return activityService.save(a);
    }
}
