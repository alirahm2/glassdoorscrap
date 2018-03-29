package scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class TestJob implements Job {
    static int index = 0;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        index ++ ;
        System.out.println(index);
        try {
            Thread.sleep(3000);
            System.out.println("after sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
