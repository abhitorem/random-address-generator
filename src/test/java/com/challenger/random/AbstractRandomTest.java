package com.challenger.random;

import com.challenger.random.model.AddressTest;
import com.challenger.random.model.Randomizer;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@SpringBootTest(classes = AddressTest.class)
@JsonTest
public class AbstractRandomTest {

    @Spy
    protected Randomizer randomizer;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);

        Logger rootLogger = LogManager.getLogManager().getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        rootLogger.setLevel(Level.INFO);
        for (Handler h : handlers) {
            h.setLevel(Level.INFO);
        }
    }
}

