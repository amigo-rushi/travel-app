package com.microservice.PassengerService.Services;

import com.microservice.PassengerService.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.PassengerService.repo.PassengerRepository;

import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository repository;

    public Passenger createPassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public Optional<Passenger> getPassenger(Long id) {
        return repository.findById(id);
    }

    public void deletePassenger(Long id) {
        repository.deleteById(id);
    }
}
