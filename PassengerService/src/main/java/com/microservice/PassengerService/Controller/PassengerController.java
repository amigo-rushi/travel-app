package com.microservice.PassengerService.Controller;

import com.microservice.PassengerService.Services.PassengerService;
import com.microservice.PassengerService.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerService service;
    @GetMapping
    public String getAllPassengers() {
        return "List of all passengers"; // Replace with actual logic
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok(service.createPassenger(passenger));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Long id) {
        return service.getPassenger(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        service.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
