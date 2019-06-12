### 【一个不错的记录日志的案例】（采用自定义注解 + aop）
效果如下
```
2019-06-12 17:24:27.325  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : ====================【start】=====================
2019-06-12 17:24:27.325  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【URL】           ：http://localhost:8080/webLog/login
2019-06-12 17:24:27.325  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【DESCRIPTION】   ：用户登录
2019-06-12 17:24:27.326  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【METHOD】        ：POST
2019-06-12 17:24:27.326  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Class Method】  ：com.gaoqiangwei.gaozirecordlog.controller.TestWebLogController.login
2019-06-12 17:24:27.326  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【IP】            ：0:0:0:0:0:0:0:1
2019-06-12 17:24:27.326  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Request args】  ：[{"name":"高仔","age":18}]
2019-06-12 17:24:27.327  INFO 15556 --- [nio-8080-exec-3] c.g.g.controller.TestWebLogController    : user login
2019-06-12 17:24:27.327  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Response args】  ："login success"
2019-06-12 17:24:27.327  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Time-consuming】：2ms
2019-06-12 17:24:27.327  INFO 15556 --- [nio-8080-exec-3] c.g.gaozirecordlog.aspect.WebLogAspect   : ====================【end】=======================

2019-06-12 17:24:28.265  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : ====================【start】=====================
2019-06-12 17:24:28.265  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【URL】           ：http://localhost:8080/webLog/login
2019-06-12 17:24:28.265  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【DESCRIPTION】   ：用户登录
2019-06-12 17:24:28.265  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【METHOD】        ：POST
2019-06-12 17:24:28.265  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Class Method】  ：com.gaoqiangwei.gaozirecordlog.controller.TestWebLogController.login
2019-06-12 17:24:28.266  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【IP】            ：0:0:0:0:0:0:0:1
2019-06-12 17:24:28.267  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Request args】  ：[{"name":"高仔","age":18}]
2019-06-12 17:24:28.267  INFO 15556 --- [nio-8080-exec-4] c.g.g.controller.TestWebLogController    : user login
2019-06-12 17:24:28.267  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Response args】  ："login success"
2019-06-12 17:24:28.267  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : 【Time-consuming】：2ms
2019-06-12 17:24:28.267  INFO 15556 --- [nio-8080-exec-4] c.g.gaozirecordlog.aspect.WebLogAspect   : ====================【end】=======================
```
### <a href ="https://mp.weixin.qq.com/s?__biz=MzA3ODQ0Mzg2OA==&mid=2649049700&idx=1&sn=bdf966758028aabe2d264ac6e9deb2f7&chksm=87534e57b024c741cf762b3b048606e1ebbfa10f8db3f3825fa8248dac2c5a379e4617181558&mpshare=1&scene=24&srcid=&key=864f666bf054558483e02a79e7433f13d716c6a323a287a9e52e98336b4740d375ba0850feaf946597e2be8a8eb75bc3cc96bf07bdf67e4ca2a6055a47059d4a2374d5d1ac902460da1fdd464514ec1e&ascene=14&uin=MTg4OTY0MzA4NA%3D%3D&devicetype=Windows+10&version=62060833&lang=zh_CN&pass_ticket=S7gQomsSTPNwVY8GtNqidmgVZhMhxTCDExU4zpxKCrbUKQQGAYqUA56l83Xl5Vfh">【参考原文】</a>
