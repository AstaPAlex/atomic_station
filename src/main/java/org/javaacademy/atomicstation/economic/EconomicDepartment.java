package org.javaacademy.atomicstation.economic;

import java.math.BigDecimal;
import lombok.Getter;
import org.javaacademy.atomicstation.config.Log;
import org.springframework.beans.factory.annotation.Value;

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
