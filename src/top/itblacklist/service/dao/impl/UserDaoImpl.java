package top.itblacklist.service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.itblacklist.service.dao.IUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements IUserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save() {
        System.out.println("保存方法");
        try{
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into user(username) values (?)");
            ps.setString(1, "zhangsan");
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
