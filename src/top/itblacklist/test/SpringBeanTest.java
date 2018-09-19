package top.itblacklist.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.itblacklist.bean.UserBean;
import top.itblacklist.bean.UserBean1;

public class SpringBeanTest {

    @Test
    public void testSpringBeanFactory() throws Exception{
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory =  new XmlBeanFactory(resource);

        UserBean userBean1 = (UserBean) beanFactory.getBean("userBean1");
//        UserBean userBean2 = beanFactory.getBean("userBean2", UserBean.class);
        UserBean1 userBean3 = beanFactory.getBean(UserBean1.class);

        userBean1.hello();
//        userBean2.hello();
        userBean3.hello();

    }

    @Test
    public void testSpringActionContext() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean userBean = (UserBean) applicationContext.getBean("userBean1");
        userBean.hello();
    }


}
