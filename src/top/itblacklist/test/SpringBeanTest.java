package top.itblacklist.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.itblacklist.bean.UserBean;

public class SpringBeanTest {

    @Test
    public void testSpringBean() throws Exception{
        Resource resource = new ClassPathResource("applicactionContext.xml");
        BeanFactory beanFactory =  new XmlBeanFactory(resource);

        UserBean userBean1 = (UserBean) beanFactory.getBean("userBean1");
        UserBean userBean2 = beanFactory.getBean("userBean2", UserBean.class);
        userBean1.hello();
        userBean2.hello();
    }


}
