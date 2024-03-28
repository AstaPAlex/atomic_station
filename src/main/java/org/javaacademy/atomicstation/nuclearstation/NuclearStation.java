package org.javaacademy.atomicstation.nuclearstation;

import lombok.RequiredArgsConstructor;
import org.javaacademy.atomicstation.economic.EconomicDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NuclearStation {
    @Autowired
    @Lazy
    private SecurityDepartment securityDepartment;
    private final ReactorDepartment reactorDepartment;
    private final EconomicDepartment economicDepartment;
    private int accidentCountAllTime = 0;
    private long countEnergyAllTime = 0;
    private static final String TEXT_ACCIDENT = "Внимание! Происходят работы на атомной станции! Электричества нет!";

    protected void startYear() {
        infoStart();
        long countEnergyYear = 0;
        for (int i = 1; i <= 365; i++) {
            try {
                countEnergyYear += reactorDepartment.run();
                reactorDepartment.stop();
            } catch (Exception e) {
                System.out.println(TEXT_ACCIDENT);
            }
        }
        infoEnd(countEnergyYear);
        countEnergyAllTime += countEnergyYear;
        securityDepartment.reset();
    }

    public void start(int year) {
        for (int i = 1; i <= year; i++) {
            startYear();
        }
        System.out.printf("Количество инцидентов за всю работу станции: %s\n", accidentCountAllTime);
    }

    protected void incrementAccident(int count) {
        accidentCountAllTime += count;
    }

    private void infoStart() {
        System.out.printf("""
                Действие происходит в стране: %s
                Атомная станция начала работу
                """, economicDepartment.getName());
    }

    private void infoEnd(long countEnergyYear) {
        System.out.printf("""
                Атомная станция закончила работу.
                За год вырабатано %s киловатт/часов
                Количество инцидентов за год: %s
                Доход за год составил: %.2f %s
                """, countEnergyYear, securityDepartment.getCountAccidents(),
                economicDepartment.computeYearIncomes(countEnergyYear), economicDepartment.getCurrency());
    }
}
