package org.javaacademy.atomicstation.nuclearstation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
class NuclearStationTest {

    @Autowired
    NuclearStation nuclearStation;

    @Test
    void startSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(1));
    }

    @Test
    void incrementAccidentSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.incrementAccident(1));
    }

}