package top.itblacklist.springtest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.itblacklist.bean.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserBean userBean;

    /**
     * 这个UserBean我们已经在Spring中配置好。交给Spring来管理
     * Spring即可以来创建这个对象，再把这个对象注入进来
     */
    @Test
    public void testGetUserBean(){
        userBean.hello();
    }
}
