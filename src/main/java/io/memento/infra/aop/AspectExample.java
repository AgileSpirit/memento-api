package io.memento.infra.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

/**
 * An example of AOP in action.
 */
@Aspect
@Named
public class AspectExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectExample.class);

    /**
     * Advice method that surround the call to the domain services.
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(* io.memento.domain.*Service.*(..))")
    public Object inDomainServicesLayer(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("Call service " + pjp.getSignature().getName() + " with arguments: (TODO)");
        return pjp.proceed();
    }

}
