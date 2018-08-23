package sacc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sacc.domain.Category;
import sacc.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public List<Category> getAll() throws SQLException {
        // 查询操作
        String sql = "select * from category";
        // 执行sql
        List<Category> allCate=null;
        allCate = qr.query(sql,new BeanListHandler<Category>(Category.class));
        return allCate;
    }
}
