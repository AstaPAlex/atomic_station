package org.javaacademy.atomicstation.economic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
@ActiveProfiles("france")
class FranceEconomicDepartmentTest {
    @Autowired
    FranceEconomicDepartment franceEconomicDepartment;

    @Test
    void computeYearIncomesSuccess() {
        Assertions.assertEquals(
                BigDecimal.valueOf(495_000_000).setScale(1, RoundingMode.CEILING),
                franceEconomicDepartment.computeYearIncomes(1_000_000_000)
        );
    }
}