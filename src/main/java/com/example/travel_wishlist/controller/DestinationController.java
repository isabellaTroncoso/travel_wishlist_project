package com.example.travel_wishlist.controller;

import com.example.travel_wishlist.model.Destination;
import com.example.travel_wishlist.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationRepository repository;

    public DestinationController(DestinationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Destination> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Destination create(@RequestBody Destination destination) {
        return repository.save(destination);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

