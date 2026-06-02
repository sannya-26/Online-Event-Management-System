package com.eventsystem.controller;

import com.eventsystem.model.Booking;
import com.eventsystem.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import com.eventsystem.model.User;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{userId}/{eventId}/{quantity}")
    public String bookTicket(
            @PathVariable Long userId,
            @PathVariable Long eventId,
            @PathVariable int quantity){

        return bookingService.bookTicket(
                userId,
                eventId,
                quantity
        );
    }

    @GetMapping("/history/{userId}")
    public List<Booking> history(
            @PathVariable Long userId){

        return bookingService.getBookingHistory(userId);
    }
}
