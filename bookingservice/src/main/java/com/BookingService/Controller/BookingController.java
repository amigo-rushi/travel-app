package com.BookingService.Controller;

import com.BookingService.Services.BookingService;
import com.BookingService.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService service;

    @GetMapping
    public ResponseEntity<String> getBookings() {
        return ResponseEntity.ok("Booking Service is working!");
    }
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(service.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        return service.getBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        service.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }
}
