package com.virtualMed.brone.repository;

import com.virtualMed.brone.model.Meeting;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingReserveRepository  extends JpaRepository<Meeting, Long> {
    List<Meeting> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

}
