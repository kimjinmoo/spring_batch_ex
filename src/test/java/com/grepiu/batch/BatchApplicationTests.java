package com.grepiu.batch;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBatchTest
@SpringBootTest
class BatchApplicationTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    void contextLoads() {
    }

    @Test
    public void doTestSampleJob() throws Exception {
        jobLauncherTestUtils.launchJob();
    }

    @Configuration
    public class TestUtilContext {

        @Autowired
        @Qualifier("sampleJob")
        private Job job;

        @Bean
        public JobLauncherTestUtils jobLauncherTestUtils() {
            JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
            jobLauncherTestUtils.setJob(job);
            return jobLauncherTestUtils;
        }
    }
}
