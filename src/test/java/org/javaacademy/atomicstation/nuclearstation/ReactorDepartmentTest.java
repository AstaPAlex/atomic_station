package org.javaacademy.atomicstation.nuclearstation;

import lombok.SneakyThrows;
import org.javaacademy.atomicstation.nuclearstation.exceptions.ReactorWorkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReactorDepartmentTest {
    @Autowired
    ReactorDepartment reactorDepartment;

    @SneakyThrows
    @Test
    void startSuccess() {
        Assertions.assertEquals(10_000_000, reactorDepartment.run());
    }

    @SneakyThrows
    @Test
    void startFail() {
        reactorDepartment.run();
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.run());
    }

    @SneakyThrows
    @Test
    void stopSuccess() {
        reactorDepartment.run();
        Assertions.assertDoesNotThrow(() -> reactorDepartment.stop());
    }

    @Test
    void stopFail() {
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.stop());
    }


}