package com.techjava.springbootbatchcsvtodbdemo.writer;

import com.techjava.springbootbatchcsvtodbdemo.model.Ticket;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TicketWriter {

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Ticket> writer(){
        JdbcBatchItemWriter<Ticket> writer = new JdbcBatchItemWriter<Ticket>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Ticket>());
        writer.setSql("INSERT INTO ticket (booking_date,dest_station,email,passenger_name,source_station) VALUES (:bookingDate, :toStation,:email,:passengerName,:fromStation)");
        writer.setDataSource(dataSource);
        return writer;
    }
}
