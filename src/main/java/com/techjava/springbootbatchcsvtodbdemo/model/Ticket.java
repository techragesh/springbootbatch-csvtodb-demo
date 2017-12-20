package com.techjava.springbootbatchcsvtodbdemo.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Ticket {


    private Integer ticketId;

    private String passengerName;

    private String fromStation;

    private String toStation;

    private Date bookingDate;

    private String email;
    private String bookingDateStr;


    public Ticket() {
    }

    public Ticket(String passengerName, String fromStation, String toStation, Date bookingDate, String email, String bookingDateStr) {
        this.passengerName = passengerName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.bookingDate = bookingDate;
        this.email = email;
        this.bookingDateStr=bookingDateStr;
    }

    public Ticket(String email, String passengerName, String fromStation) {
        this.passengerName = passengerName;
        this.fromStation = fromStation;
        this.email = email;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookingDateStr() {
        return bookingDateStr;
    }

    public void setBookingDateStr(String bookingDateStr) {
        this.bookingDateStr = bookingDateStr;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", passengerName='" + passengerName + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", bookingDate=" + bookingDate +
                ", email='" + email + '\'' +
                ", bookingDateStr='" + bookingDateStr + '\'' +
                '}';
    }
}