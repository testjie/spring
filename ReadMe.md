### spring 学习项目

1. DI/IOC
2. AOP
3. BeanFactory

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
