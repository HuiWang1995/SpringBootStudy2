# Study2
***
这个项目要完成前端能查询到数据库。
所以创建时除了选择web,还要选择一下mysql、jpa
***
首先要像上个工程一样，保证浏览器能访问到controller，
不再赘述。

这儿就是创建了**CURDController.java**

```java
@RestController
public class CRUDController {
    @Autowired
    private CRUDService crudService;
    @RequestMapping("/getAll")
    public String getAll(){
        return "abc";
    }
}
```

接着就是**Sevice层**代码。
**CRUDService.java**
```java
@Repository
//@Component
public interface StudyResposity extends JpaRepository<StudySpringBoot, String> {
}
```
然后是service的实现impl层
```java
@Service
public class CRUDServiceImpl implements CRUDService {
    @Autowired
    private StudyResposity studyResposity;
    @Override
    public String getAll() {
        return studyResposity.findAll().toString();
    }
}
```
***
StudyResposity就是数据库层的接口，是集成jpa的接口来完成数据库的查询
**dao层 StudyResposity.java**
```java
@Repository
//@Component
public interface StudyResposity extends JpaRepository<StudySpringBoot, String> {
}
```
最后就是和数据库映射的pojo类，或者称为model
实体类 **StudySpringBoot.java**
```java
@Table(name = "study_spring_boot")
@Entity
public class StudySpringBoot implements Serializable {
    @Id
    private String id;
    @Column
    private String createTime;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StudySpringBoot{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
```
完成这些步骤理论上可以直接运行了。但是还是有些东西需要配置。
1. 数据库连接串 在**application.properties**中写入
```properties
#server
#tomcat端口
server.port= 80

#datasources
#数据库连接串，地址（ip、端口、数据库名）、驱动类、用户名、密码
spring.datasource.url=jdbc:mysql://tencent_server:3306/study?useUnicode=true&characterEncoding=utf8
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root-wlh

#JPA Configuration:
spring.jpa.database=MySQL
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
```
理论上这些配完就可以运行了，可是却报了Autowired没有合适的类装载。说明它并没有成功扫描到那个注解。
所以在Application中需要配置扫描路径，所以最后**Study2Application.java**改为如下
```java
@SpringBootApplication(scanBasePackages = "com.wlh.study")
@EnableJpaRepositories(basePackages = "com.wlh.study")
@EntityScan(basePackages = "com.wlh.study")
public class Study2Application {
    public static void main(String[] args) {
        SpringApplication.run(Study2Application.class, args);
    }
}
```
最后这个项目就成功运行了，从数据库中把表中所有数据查出来并显示在浏览器。
***
以前没有用过jpa，结果集成它意外的方便好用呵呵呵。
只需要继承一个接口就行，不过它默认使用的是hibernate，
应该有办法可以改成其他的吧。