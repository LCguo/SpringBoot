package com.mine.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author longcheng.guo
 */
@Aspect
@Component
public class LoggerAspect {

    private Logger logger = null;
    //切入点描述 这个是controller包的切入点
    @Pointcut(value = "execution(public * com.mine.springboot.module.*.service..*.*(..))")
   /**
    *  签名，可以理解成这个切入点的一个名称
    */
    public void controllerLog(){}
    /**
     * 在切入点的方法run之前要干的
     */
    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) {

        logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
        logger.info("#CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        // 记录下请求内容
        logger.info("#URL : " + request.getRequestURL().toString());
        logger.info("#HTTP_METHOD : " + request.getMethod());
        logger.info("#IP : " + request.getRemoteAddr());
        logger.info("#THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
    }

}
