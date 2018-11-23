package com.banban.cdistats.repository;

import com.banban.cdistats.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    Optional<TimeSlot> findByNameAndDayOfWeek(String name, DayOfWeek dayOfWeek);

    Set<TimeSlot> findByName(String name);
}
