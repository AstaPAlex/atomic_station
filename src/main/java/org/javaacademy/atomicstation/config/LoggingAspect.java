package org.javaacademy.atomicstation.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Around("@annotation(org.javaacademy.atomicstation.config.Log)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String fullMethodName = className + "." + methodName;
        Object[] methodArgs = joinPoint.getArgs();
        log.info("вызов метода {} с аргументами {}", fullMethodName, methodArgs);
        Object result = joinPoint.proceed(methodArgs);
        log.info("результат работы метода {}: {}", fullMethodName, result);
        return result;
    }

}
