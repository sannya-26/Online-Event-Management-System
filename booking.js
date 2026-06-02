package com.eventsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventsystem.model.Role;
import com.eventsystem.model.Booking;
import com.eventsystem.model.Event;
import com.eventsystem.repository.BookingRepository;
import com.eventsystem.repository.EventRepository;
import com.eventsystem.model.User;
import com.eventsystem.repository.UserRepository;
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    public String bookTicket(
            Long userId,
            Long eventId,
            int quantity){

        Event event=
                eventRepository.findById(eventId)
                        .orElseThrow();

        User user=
                userRepository.findById(userId)
                        .orElseThrow();
        if(user.getRole()!=Role.CUSTOMER){

            return "Only Customer can book";
        }
        int available=
                event.getTotalTickets()
                        -event.getSoldTickets();

        if(quantity>available){
            return "Tickets Not Available";
        }

        event.setSoldTickets(
                event.getSoldTickets()+quantity
        );

        eventRepository.save(event);

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setEvent(event);
        booking.setQuantity(quantity);

        bookingRepository.save(booking);

        return "Booking Successful";
    }

    public List<Booking> getBookingHistory(Long userId){

        return bookingRepository
                .findByUserId(userId);
    }
}