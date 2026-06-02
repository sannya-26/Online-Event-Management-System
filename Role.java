package com.eventsystem.controller;

import com.eventsystem.model.Event;
import com.eventsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {

        return eventService.getAllEvents();
    }

//    @PostMapping
//    public Event createEvent(
//            @RequestBody Event event) {
//
//        return eventService.createEvent(event);
//    }

    @GetMapping("/{id}")
    public Event getEvent(
            @PathVariable Long id){

        return eventService.getEvent(id);
    }
    @PostMapping("/{userId}")
    public Event addEvent(
            @PathVariable Long userId,
            @RequestBody Event event){

        return eventService
                .addEvent(userId,event);
    }

    @GetMapping("/organizer/{id}")
    public List<Event> getOrganizerEvents(
            @PathVariable Long id){

        return eventService
                .getOrganizerEvents(id);
    }
    @GetMapping("/search")
    public List<Event> search(
            @RequestParam String title){

        return eventService
                .searchEvents(title);
    }

}