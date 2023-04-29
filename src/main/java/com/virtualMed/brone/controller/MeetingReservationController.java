package com.virtualMed.brone.controller;

import com.virtualMed.brone.model.Meeting;
import com.virtualMed.brone.service.MeetingReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v2/reservations")
@RequiredArgsConstructor
public class MeetingReservationController {

    private final MeetingReservationService service;


    @GetMapping
    public List<Meeting> getAllMeetingReservations() {
        return service.getAllMeetingReservations();
    }

    @PostMapping
    public Meeting createMeetingReservation(@RequestBody Meeting meetingReservation) {
        return service.createMeetingReservation(meetingReservation);
    }

    @PutMapping("/{id}")
    public Meeting updateMeetingReservation(@PathVariable Long id, @RequestBody Meeting meetingReservation) {
        Meeting existingMeetingReservation = service.getMeetingReservationById(id);
        existingMeetingReservation.setStartTime(meetingReservation.getStartTime());
        existingMeetingReservation.setEndTime(meetingReservation.getEndTime());
        return service.updateMeetingReservation(existingMeetingReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteMeetingReservation(@PathVariable Long id) {
        service.deleteMeetingReservation(id);
    }

//    @GetMapping(params = {"start", "end"})
//    public List<Meeting> getMeetingReservationsBetween(@RequestParam("start") String start, @RequestParam("end") String end) {
//        LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
//        LocalDateTime endTime = LocalDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
//        return service.getMeetingReservationsBetween(startTime, endTime);
//    }
}

