package org.javaacademy.atomicstation.economic;

import java.math.BigDecimal;

public class MoroccoEconomicDepartment extends EconomicDepartment {

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal incomes = BigDecimal.ZERO;
        if (countElectricity > 5_000_000) {
            incomes = incomes.add(BigDecimal.valueOf((countElectricity - 5_000_000)));
        }
        incomes = incomes.add(BigDecimal.valueOf(countElectricity * price));
        return incomes;
    }
}
