package org.javaacademy.atomicstation.economic;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;

@Getter
public abstract class EconomicDepartment {
    @Value("${economicdepartment.name}")
    protected String name;
    @Value("${economicdepartment.currency}")
    protected String currency;
    @Value("${economicdepartment.price}")
    protected double price;

    public abstract BigDecimal computeYearIncomes(long countElectricity);
}
