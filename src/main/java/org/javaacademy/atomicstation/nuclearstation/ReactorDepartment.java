package org.javaacademy.atomicstation.nuclearstation;

import lombok.RequiredArgsConstructor;
import org.javaacademy.atomicstation.nuclearstation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicstation.nuclearstation.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReactorDepartment {
    private final SecurityDepartment securityDepartment;
    private boolean isWork = false;
    private int countStart = 0;

    protected long run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает");
        }
        countStart++;
        if (countStart % 100 == 0) {
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException();
        }
        isWork = true;
        return 10_000_000;
    }

    protected void stop() throws ReactorWorkException {
        if (!isWork) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWork = false;
    }

}
