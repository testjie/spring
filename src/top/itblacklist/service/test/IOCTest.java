package top.itblacklist.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.itblacklist.service.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOCTest {

    @Autowired
    UserAction userAction;

    @Test
    public void testIOC() throws Exception{
        userAction.save();
    }
}
