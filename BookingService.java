package com.eventsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private Double ticketPrice;
    private Integer totalTickets;
    private Integer soldTickets = 0;

    @ManyToOne
    @JsonIgnore
    private User organizer;

    public Event(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Integer getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Integer soldTickets) {
        this.soldTickets = soldTickets;
    }

    public Integer getRemainingTickets() {
        return totalTickets - soldTickets;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getRevenue() {

        if(ticketPrice == null){
            return 0.0;
        }

        return soldTickets * ticketPrice;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer){
        this.organizer = organizer;
    }
}