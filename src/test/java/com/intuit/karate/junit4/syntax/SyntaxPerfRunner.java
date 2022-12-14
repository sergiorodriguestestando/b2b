package com.intuit.karate.junit4.syntax;

import com.intuit.karate.Runner;
import java.util.Collections;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pthomas3
 */
public class SyntaxPerfRunner {

    private static final Logger logger = LoggerFactory.getLogger(SyntaxPerfRunner.class);
    
    @Test
    public void testPerf() {
        System.setProperty("karate.env", "foo");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Runner.runFeature(getClass(), "syntax.feature", Collections.EMPTY_MAP, true);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("elapsed time: {}", elapsedTime);
        // 25.5 seconds for git 76c92bd
        // 14.0 seconds after refactoring
        // 11.0 seconds after second wave git 20445d5
        //  9.0 seconds on new mac 6795ae8
    }
    
    public static void main(String[] args) {
        new SyntaxPerfRunner().testPerf();
    }
    
}
