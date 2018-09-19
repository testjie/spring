### spring 学习项目

####. DI/IOC
    DI:依赖注入
    IOC：控制反转：将初始化对象的任务交给spring容器来管理，不主动初始化对象
#### AOP
    面向切面编程：比较高端
#### BeanFactory

```
1.	BeanFactory是Spring的一个核心接口
2.	BeanFactory的主要作用是拿到实例化，配置与管理Bean对象
3.	BeanFactory拿Spring有三种方式(id,类型,id与类型)


    @Test
    public void testSpringBean() throws Exception{
        Resource resource = new ClassPathResource("applicactionContext.xml");
        BeanFactory beanFactory =  new XmlBeanFactory(resource);

        UserBean userBean1 = (UserBean) beanFactory.getBean("userBean1");
        UserBean userBean2 = beanFactory.getBean("userBean2", UserBean.class);
        UserBean1 userBean3 = beanFactory.getBean(UserBean1.class);

        userBean1.hello();
        userBean2.hello();
        userBean3.hello();

    }
    
```


#### ActionContext

```
1.	ApplicationContext是一个BeanFactory的实现
2.	ApplicationContext比BeanFactory实现了更多的功能(国际化，事件传播...)
3.	ApplicationContext与BeanFactory的区别(面试题)

解释：ApplicationContext是BeanFactory的子接口,拥有更多的功能与方法
重点：ApplicationContext对bean是在读取的时候就创建Bean对象，而BeanFactory是在使用的时候才进行对象的创建(懒加载)
懒加载是指在需要使用对象的时候才加载，通常情况下适用于访问数据量较大时，内存较少。

    @Test
    public void testSpringActionContext() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicactionContext.xml");
        UserBean userBean = (UserBean) applicationContext.getBean("userBean1");
        userBean.hello();
    }
```

#### 懒加载的配置

```
    1. 全局懒加载
    <beans xmlns="http://www.springframework.org/schema/beans"
    ....
    default-lazy-init="true"/>
    
    2. 局部bean懒加载
    <bean id="userBean3" class="top.itblacklist.bean.UserBean1" lazy-init="true"/>
    
```


#### Spring自带测试

```
1.	Spring单独写一套测试，可以在不启动服务的情况下读取相应的配置文件
2.	使用Spring测试需要导入Junit包，Spring的测试与，Spring的aop包
3.	注意Spring测试中读取配置文件路径


  @RunWith:代表你现在使用哪一个Junit环境来做Spring
  		当前测试跑在哪一个Spring支持的Junit下面
 		SpringJUnit4ClassRunner:代表是Junit4的测试环境
 
 @ContextConfiguration：找到我们的核心配置文件
 
```

#### Spring的bean作用域

```
    那些层应该是单例:dao层,service层,DataSource,SessionFactory
    那些层不应该是单例,多例(获取一次就new一次)?struts2：action层
    domain层,util层不由spring管理,自己管理
    
    
    Bean节点有个属性scope
    singleton,默认值,单例
    prototype,多例  
    <bean id="scopeBean" class="cn.itsource._03_scope.MyScopeBean" scope="prototype"></bean>

```

#### Spring的Bean对象的生命周期

```
生命周期：构造 （创建）-> 初始化->运行-> 销毁   
bean创建之后 就直接初始化 ，初始化运行之后，就销毁
配置多例的情况下，不会执行销毁（手动回收gc()）


```


#### Spring三层注入
service层

#### Spring注入dataSource+properties文件

```xml
<beans>
    <!--加载外部properties文件-->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!--配置DataSource-->
    <bean name="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--三层配置-->
    <!--配置userDao的bean-->
    <bean name="userDaoImpl" class="top.itblacklist.service.dao.impl.UserDaoImpl">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置userService-->
    <bean name="userService" class="top.itblacklist.service.service.impl.UserServiceImpl">
        <!--xml注入userDao到userDao对象-->
        <property name="userDao" ref="userDaoImpl"/>
    </bean>

    <!--配置userAction,并注入到userServer-->
    <bean name="userAction" class="top.itblacklist.service.action.UserAction">
        <property name="userService" ref="userService"></property>
    </bean>
</beans>
```