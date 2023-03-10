package tn.esprit._3cinfogl1.assuranceproject.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {


    @After("execution(* tn.esprit._3cinfogl1.assuranceproject.Services.*.get*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Bon Courage!" + name );
    }


    /*@Before("execution(* tn.esprit._3cinfogl1.assuranceproject.Services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }*/

}
