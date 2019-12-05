package com.grepiu.batch.config.job;

import com.grepiu.batch.config.task.SampleTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Spring 배치 설정
 *
 */
@Configuration
@EnableBatchProcessing
public class SampleJobConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step sampleStep(){
        return steps
                .get("sampleStep")
                .tasklet(new SampleTask())
                .build();
    }

    @Bean
    public Job sampleJob() {
        return jobs
                .get("sampleJob")
                .start(sampleStep())
                .build();
    }


}
