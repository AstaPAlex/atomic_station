package org.javaacademy.atomicstation.economic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("morocco")
class MoroccoEconomicDepartmentTest {
    @Autowired
    MoroccoEconomicDepartment moroccoEconomicDepartment;

    @Test
    void computeYearIncomesSuccess() {
        Assertions.assertEquals(
                BigDecimal.valueOf(31_000_000_000L),
                moroccoEconomicDepartment.computeYearIncomes(6_000_000_000L)
        );
    }

}