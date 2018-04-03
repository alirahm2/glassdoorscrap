package logging;


import org.apache.log4j.Logger;

public class LoggingExample {
    final static Logger logger = Logger.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("khodafez");
    }
}
