package com.gaoqiangwei.gaozirecordlog.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>WebLog
 * 1、什么时候使用该注解，我们定义为运行时
 * 2、注解用于什么地方，我们定义为作用于方法上
 * 3、注解是否将包含在JavaDoc中，我们选择是
 * 4、注解名为WebLog
 * 5、定义一个属性，用来对注解的值进行描述，默认为空字符串
 * 总结：以上，就是一个完整的自定义注解
 * </p>
 *
 * @author gaoqiangwei
 * @date 2019/6/12 15:14
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";
}