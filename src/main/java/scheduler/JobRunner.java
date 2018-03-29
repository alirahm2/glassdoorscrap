package scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobRunner {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(TestJob.class)
                .withIdentity("dummyJobName", "group1").build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(1).repeatForever())
                .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}
