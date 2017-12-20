package com.techjava.springbootbatchcsvtodbdemo.config;

import com.techjava.springbootbatchcsvtodbdemo.listener.TicketListener;
import com.techjava.springbootbatchcsvtodbdemo.model.Ticket;
import com.techjava.springbootbatchcsvtodbdemo.processor.TicketItemProcessor;
import com.techjava.springbootbatchcsvtodbdemo.reader.TicketReader;
import com.techjava.springbootbatchcsvtodbdemo.writer.TicketWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class TicketBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private TicketReader ticketReader;

    @Autowired
    private TicketWriter ticketWriter;

    @Autowired
    private TicketItemProcessor ticketItemProcessor;


    @Bean
    public FlatFileItemReader<Ticket> getTicketReader(){
       return ticketReader.reader();
    }

    @Bean
    public JdbcBatchItemWriter<Ticket> batchItemWriter(){
        return ticketWriter.writer();
    }

    @Bean
    public Job importUserJob(TicketListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Ticket, Ticket> chunk(2)
                .reader(getTicketReader())
                .processor(ticketItemProcessor)
                .writer(batchItemWriter())
                .build();
    }

}
