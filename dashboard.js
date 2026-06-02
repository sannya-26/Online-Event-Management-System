package com.eventsystem.service;

import com.eventsystem.model.Event;
import com.eventsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventsystem.model.User;
import com.eventsystem.repository.UserRepository;
import java.util.List;
import com.eventsystem.model.Role;
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Event addEvent(
            Long userId,
            Event event){

        User organizer =
                userRepository.findById(userId)
                        .orElseThrow();

        if(organizer.getRole()
                != Role.ORGANIZER){

            throw new RuntimeException(
                    "Only Organizer can create event"
            );
        }

        event.setOrganizer(
                organizer
        );

        return eventRepository
                .save(event);
    }

    public List<Event> getAllEvents(){

        return eventRepository.findAll();
    }

    public Event getEvent(Long id){

        return eventRepository
                .findById(id)
                .orElse(null);
    }
    public List<Event> getOrganizerEvents(
            Long id){

        return eventRepository
                .findByOrganizerId(id);
    }
    public List<Event> searchEvents(
            String title){

        return eventRepository
                .findByTitleContaining(title);
    }
}