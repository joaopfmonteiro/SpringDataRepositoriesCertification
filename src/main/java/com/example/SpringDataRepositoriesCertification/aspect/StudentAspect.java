package com.example.SpringDataRepositoriesCertification.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Aspect
@Named
public class StudentAspect {

    private Logger LOG = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Pointcut("execution(* com.student.service.*.*(..))")
    public void log() {
    }
    @Before("log()")
    public void before(JoinPoint jp) {
        LOG.info("Invoked Method Before->" + jp.getSignature().getName());
    }
    @After("log()")
    public void after(JoinPoint jp) {
        LOG.info("Invoked Method After->" + jp.getSignature().getName());
    }

}
