# StudySpringBoot2
***
这是第二个学习Spring的项目，这个项目的主要目的是连接上数据库。使得前台能拿到数据。
***
## Problem Faced 
遇到的问题
### 1. 连接不上数据库
#### 1.1 Loading class `com.mysql.jdbc.Driver'. This is deprecated
这个属于警告，这个警告也提示了，这个驱动已经被抛弃了，而且有个能代替他的。
配置中改成**com.mysql.cj.jdbc.Driver**就行了。
#### 1.2 CommunicationsException: Communications link failure
连接不上数据库，最后发现是数据库的连接串错了（因为是传到github上的项目，所以特地在hosts文件中做了设置）。
只要保证这个连接串能正常连接就行。

### 2. Controller映射不到
打开页面发现404了。猜到是没扫描这个controller包了，但是为什么第一个项目可以呢？
因为第一个项目的包名是Application所在包的子包。
所以这次要配置
**@SpringBootApplication(scanBasePackages = "com.wlh.study")**

### 3. 数据库连接通过jpa接口无法被实例化，启动失败
 No qualifying bean of type 'xxx.xxx.xxx' available: expected at least 1 bean which qualifies as autowire candidate. 
 
 一开始以为是我没用过jpa（别笑），所以集成的时候导致少了些配置。
 jpa真的强大，只要写接口，都不要写实现类，好不习惯。
 
 最后觉得是@等注解没有被扫描，所以没有实例化，结果还真是。。
 调整了如下就可以了，少了两个注解。
 >@SpringBootApplication(scanBasePackages = "com.wlh.study")
 @EnableJpaRepositories(basePackages = "com.wlh.study")
 @EntityScan(basePackages = "com.wlh.study")
 >
 这样项目就能起来，并且能查出数据了。
 