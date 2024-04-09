package org.javaacademy.atomicstation.economic;

import java.math.BigDecimal;

public class FranceEconomicDepartment extends EconomicDepartment {

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal incomes = BigDecimal.ZERO;
        int div = (int) (countElectricity / 1_000_000_000);
        for (int i = 1; i <= div; i++) {
            incomes = incomes.add(BigDecimal.valueOf(1_000_000_000 * Math.pow(0.99, i)));
        }
        return incomes.multiply(BigDecimal.valueOf(price));
    }
}
