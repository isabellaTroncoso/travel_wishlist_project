package com.example.travel_wishlist.destination;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class DestinationController {

    private final DestinationRepository destinationRepository;

    public DestinationController(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("destinations", destinationRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addDestination(@RequestParam String destination,
                                 @RequestParam String description,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Destination dest = new Destination();
        dest.setDestination(destination);
        dest.setDescription(description);
        dest.setDate(date);
        destinationRepository.save(dest);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteDestination(@PathVariable Long id) {
        destinationRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editDestination(@PathVariable Long id, Model model) {
        Destination destination = destinationRepository.findById(id).orElseThrow();
        model.addAttribute("destination", destination);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateDestination(@PathVariable Long id,
                                    @RequestParam String description,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Destination destination = destinationRepository.findById(id).orElseThrow();
        destination.setDescription(description);
        destination.setDate(date);
        destinationRepository.save(destination);
        return "redirect:/";
    }

}