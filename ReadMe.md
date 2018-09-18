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