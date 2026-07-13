package com.sky.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.sky..*.*(..))")
    public void logPointCut(){}

    @Around("logPointCut() && @annotation(com.sky.annotation.Loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        long start = System.currentTimeMillis();

        log.info("-------------------------\n" +
                "开始执行方法:{}, 参数:{}", methodName, args);

        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;

        log.info("方法:{} 执行完毕, 耗时:{}ms, 返回值:{}", methodName, time, result);
        return result;
    }
}
