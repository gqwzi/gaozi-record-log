package com.gaoqiangwei.gaozirecordlog.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>日志切面类
 * </p>
 *
 * @author gaoqiangwei
 * @date 2019/6/12 15:22
 **/
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /**
     * 以自定义@WebLog注解为切入点
     * 备注：annotation的值就是WebLog注解的全路径
     */
    @Pointcut("@annotation(com.gaoqiangwei.gaozirecordlog.aspect.WebLog)")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        //执行切入点
        Object result = proceedingJoinPoint.proceed();
        //打印返回参数
        log.info("【Response args】  ：{}", new Gson().toJson(result));
        long endTime = System.currentTimeMillis();
        //打印请求耗时
        log.info("【Time-consuming】：{}ms", endTime-startTime);
        return result;
    }

    /**
     * 在切点之前植入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //获取request对象，便于打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取注解的详细信息
        String description = getAspectLogDescription(joinPoint);

        //打印请求相关参数
        log.info("====================【start】=====================");
        //打印请求 url
        log.info("【URL】           ：{}", request.getRequestURL().toString());
        //打印描述信息
        log.info("【DESCRIPTION】   ：{}", description);
        //打印http method
        log.info("【METHOD】        ：{}", request.getMethod());
        //打印调用controller的全路径以及执行方法
        log.info("【Class Method】  ：{}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        //打印请求的IP
        log.info("【IP】            ：{}", request.getRemoteAddr());
        //打印请求入参
        log.info("【Request args】  ：{}", new Gson().toJson(joinPoint.getArgs()));
    }

    /**
     * 在切入点之后植入
     */
    @After("webLog()")
    public void doAfter(){
        //接口结束后换行，方便查看
        log.info("====================【end】=======================" + System.lineSeparator());
    }

    /**
     * 获取注解的描述信息
     * @param joinPoint
     * @return
     */
    public String getAspectLogDescription(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        WebLog webLog = methodSignature.getMethod().getAnnotation(WebLog.class);
        return webLog.description();
    }
}