package com.virtualMed.brone.service;

import com.virtualMed.brone.model.Meeting;
import com.virtualMed.brone.repository.MeetingReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingReservationService {

    private final MeetingReserveRepository repository;
    public Meeting getMeetingReservationById(Long id) {
        Optional<Meeting> meetingReservationOptional = repository.findById(id);
        if (meetingReservationOptional.isPresent()) {
            return meetingReservationOptional.get();
        } else {
            throw new NoSuchElementException("Meeting reservation not found with id " + id);
        }
    }

    public List<Meeting> getAllMeetingReservations() {
        return repository.findAll();
    }

    public Meeting createMeetingReservation(Meeting meetingReservation) {
        return repository.save(meetingReservation);
    }

    public Meeting updateMeetingReservation(Meeting meetingReservation) {
        return repository.save(meetingReservation);
    }

    public void deleteMeetingReservation(Long id) {
        repository.deleteById(id);
    }

    public List<Meeting> getMeetingReservationsBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByStartTimeBetween(start, end);
    }
}

