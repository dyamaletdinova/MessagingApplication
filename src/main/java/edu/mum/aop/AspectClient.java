package edu.mum.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// adding aspect class to the project
@Aspect
public class AspectClient {
	
	@Pointcut("within(edu.mum.service.impl.*)")
	public void allMethodsPointcut(){}
	
	@After("allMethodsPointcut()")
	public void afterAdvice(JoinPoint jpoint){
		
		Logger logger = Logger.getLogger("");
	    logger.info("   **********     TARGET CLASS : "+jpoint.toShortString());
	    System.out.println(" **********     TARGET CLASS : "+jpoint.toShortString());
	}
}
