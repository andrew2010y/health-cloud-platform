package com.nant.crm.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Configuration
public class AOP {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * com.nant.crm.*.controller..*.*(..))")
	public void webLog() {}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		//获取参数的值
		Object obj [] = joinPoint.getArgs();
		for(Object o : obj){
			logger.info(" joinPoint.getArgs() " + o);
		}
		logger.info(" Controller before ");
	}

	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint joinPoint) {
		Object obj [] = joinPoint.getArgs();
		Object target = joinPoint.getTarget();
		logger.info(" joinPoint.getSignature().getName() " +joinPoint.getSignature().getName());
		logger.info(" joinPoint.getTarget() "+target);
		for(Object o : obj){
			System.out.println(o);
		}
		logger.info("Controller.doAfterReturning()");
	}
}
