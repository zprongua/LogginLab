import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }

    @org.junit.Test
    public void thresholdReached() {
        Integer finalLimit = 7;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (int i=1; i<=10; i++) {
            if (!lab.thresholdReached(i)) {
                logger.log(Level.INFO, "Threshold not reached!\nNumber is "+i);
                assertFalse(lab.thresholdReached(i));
            }
            else if(lab.thresholdReached(i)){
                logger.log(Level.INFO, "Threshold finally reached! It is "+lab.getThreshold()+"\nNumber is "+i);
                assertTrue(lab.thresholdReached(i));
            }
            else {
                logger.log(Level.INFO, "Bad Data");
            }
        }
    }
}