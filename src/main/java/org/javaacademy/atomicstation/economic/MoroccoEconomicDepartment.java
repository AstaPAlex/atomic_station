package org.javaacademy.atomicstation.economic;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;

public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Value("${economicdepartment.additionalprice}")
    private String additionalPrice;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal incomes = BigDecimal.ZERO;
        if (countElectricity > 5_000_000_000L) {
            incomes = incomes
                    .add(BigDecimal.valueOf((countElectricity - 5_000_000_000L)))
                    .multiply(BigDecimal.valueOf(Long.parseLong(additionalPrice)));
        }
        return incomes.add(BigDecimal.valueOf(countElectricity * price));
    }
}
