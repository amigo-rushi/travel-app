package com.BookingService.Services;

import com.BookingService.entity.Booking;
import com.BookingService.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;
    public Booking createBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("Confirmed");
        return repository.save(booking);
    }

    public Optional<Booking> getBooking(Long id) {
        return repository.findById(id);
    }

    public void cancelBooking(Long id) {
        Booking booking = repository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("Cancelled");
        repository.save(booking);
    }
}
