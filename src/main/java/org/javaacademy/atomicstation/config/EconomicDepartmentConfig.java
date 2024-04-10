package org.javaacademy.atomicstation.config;

import org.javaacademy.atomicstation.economic.FranceEconomicDepartment;
import org.javaacademy.atomicstation.economic.MoroccoEconomicDepartment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EconomicDepartmentConfig {
    @Bean
    @Profile("france")
    public FranceEconomicDepartment france() {
        return new FranceEconomicDepartment();
    }

    @Bean
    @Profile("morocco")
    public MoroccoEconomicDepartment morocco() {
        return new MoroccoEconomicDepartment();
    }


}
