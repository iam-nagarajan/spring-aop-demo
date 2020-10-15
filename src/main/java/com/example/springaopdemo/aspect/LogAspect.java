package com.example.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("@annotation(com.example.springaopdemo.aspect.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String parameters = Arrays.stream(method.getParameters()).map(Objects::toString).collect(Collectors.joining(","));
        log.info("Request Method {} Parameters {}, Args {}", method.getName(), parameters, joinPoint.getArgs());
        return joinPoint.proceed();
    }
}
