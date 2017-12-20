package com.techjava.springbootbatchcsvtodbdemo.listener;

import com.techjava.springbootbatchcsvtodbdemo.model.Ticket;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TicketListener extends JobExecutionListenerSupport {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {

            List<Ticket> results = jdbcTemplate.query("SELECT email, passenger_name, source_station FROM ticket", new RowMapper<Ticket>() {
                @Override
                public Ticket mapRow(ResultSet rs, int row) throws SQLException {
                    return new Ticket(rs.getString(1),rs.getString(2),rs.getString(3));
                }
            });

            for (Ticket ticket : results) {
                System.out.println("Ticket Details-->"+ticket);
            }

        }
    }

}
