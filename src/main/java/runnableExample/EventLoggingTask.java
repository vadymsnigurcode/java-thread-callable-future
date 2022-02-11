package runnableExample;

import java.util.logging.*;

public class EventLoggingTask implements  Runnable{
    private Logger logger
            =  Logger.getLogger("runnableExample");

    @Override
    public void run() {
        logger.info("Message");
    }
}
