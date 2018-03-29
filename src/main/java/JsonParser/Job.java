package JsonParser;

import java.util.ArrayList;

public class Job {
    ArrayList<JobDetail> jobs = new ArrayList<JobDetail>();

    public ArrayList<JobDetail> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<JobDetail> jobs) {
        this.jobs = jobs;
    }

}
