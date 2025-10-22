package com.example.travel_wishlist.repository;

import com.example.travel_wishlist.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
