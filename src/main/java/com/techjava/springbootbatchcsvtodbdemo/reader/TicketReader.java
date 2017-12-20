package com.techjava.springbootbatchcsvtodbdemo.reader;

import com.techjava.springbootbatchcsvtodbdemo.config.DateUtil;
import com.techjava.springbootbatchcsvtodbdemo.model.Ticket;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class TicketReader {

    @Autowired
    private DateUtil dateUtil;

    @Bean
    public FlatFileItemReader reader(){
        FlatFileItemReader<Ticket> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("ticket.csv"));
        reader.setLineMapper(new DefaultLineMapper<Ticket>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "bookingDate", "toStation","email","passengerName","fromStation"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Ticket>() {{
                setTargetType(Ticket.class);
                setCustomEditors(dateUtil.customEditors());
            }});
        }});
        return reader;
    }
}
