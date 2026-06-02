package com.eventsystem.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    private Integer quantity;

    public Booking(){}

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event){
        this.event=event;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }
}