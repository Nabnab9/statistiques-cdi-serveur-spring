package com.banban.cdistats.service;

import com.banban.cdistats.model.Activity;
import com.banban.cdistats.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity save(Activity a) {
        return activityRepository.save(a);
    }
}
