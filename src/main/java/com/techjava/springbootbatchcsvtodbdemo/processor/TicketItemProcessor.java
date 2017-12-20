package com.techjava.springbootbatchcsvtodbdemo.processor;

import com.techjava.springbootbatchcsvtodbdemo.model.Ticket;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketItemProcessor implements ItemProcessor<Ticket, Ticket> {

    @Override
    public Ticket process(Ticket ticket) throws Exception {
        Date date = ticket.getBookingDate();
        String email = ticket.getEmail();
        String fromStation = ticket.getFromStation();
        String passengerName = ticket.getPassengerName().toUpperCase();
        String toStation = ticket.getToStation();
        String dateStr= ticket.getBookingDateStr();
        Ticket ticket1 = new Ticket(passengerName,fromStation,toStation,date,email,dateStr);
        return ticket1;
    }
}
