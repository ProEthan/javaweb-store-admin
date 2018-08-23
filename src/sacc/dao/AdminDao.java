package sacc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import sacc.domain.Admin;
import sacc.util.JdbcUtil;

import java.sql.SQLException;

public class AdminDao {
    public Admin get(String username, String password) throws SQLException {
        //获取用户名， 密码
        //到数据库当中查询有没有该用户
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select * from admin where username=? and password=?";
        Admin admin = null;
        admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
        return admin;
    }
}
