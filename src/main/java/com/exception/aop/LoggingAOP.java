package com.exception.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.context.annotation.Configuration;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

@Aspect
@Configuration
public class LoggingAOP {

    private Logger logger = Logger.getLogger(this.getClass());

    @Before("execution(* com.*.*.*(..))")
    public void beforeAdvise(JoinPoint joinPoint) {
        logger.info("Inside class ::" + joinPoint.getTarget().getClass().getName());
        logger.info("Method name::" + joinPoint.getSignature().getName() + " Starting..");
        logger.info("RunnTime argument::" + joinPoint.getArgs().length);
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            int count = 0;
            logger.info("Arg:" + (++count) + "::" + signatureArg);
        }
    }

    @After("execution(* com.*.*.*(..))")
    public void afterAdvise(JoinPoint joinPoint) {
        logger.info("Method name::" + joinPoint.getSignature().getName() + " Execution completed..");
    }

    @AfterReturning(pointcut = "execution(* com.*.*.*(..))", returning = "returnValue")
    public void afterReturningAdvise(JoinPoint joint, Object returnValue) {
        logger.info(" return::" + returnValue);//if u dnt want return response from method ,it may be confidential
        logger.info("Method run successfully No error no Exception");
    }

    @AfterThrowing(pointcut = "execution(* com.*.*.*(..))", throwing = "exception")
    public void logAfterThrowingAllMethods(Exception exception)
            throws Throwable {
        logger.info("****LoggingAspect.logAfterThrowingAllMethods() "
                + exception);
    }



}
