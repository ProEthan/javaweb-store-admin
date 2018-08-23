package sacc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import sacc.domain.Goods;
import sacc.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    // 查询操作
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public Goods get(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select * from goods where id=?";
        Goods goods = null;
        goods = qr.query(sql, new BeanHandler<Goods>(Goods.class),id);
        return goods;
    }

    // 1，从数据库当中获取所有商品列表
    public List<Goods> getAll() throws SQLException {
        // 查询操作
        String sql = "select * from goods";
        // 执行sql
        List<Goods> allGoods=null;
        allGoods = qr.query(sql,new BeanListHandler<Goods>(Goods.class));
        return allGoods;
    }

    // 2，添加商品到数据库
    public void save(Goods goods) throws SQLException {
        // 插入操作
        String sql = "insert into goods(name,price,image,descr,is_hot,cid) value(?,?,?,?,?,?)";
        // 执行
        qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getDescr(),goods.getIs_hot(),goods.getCid());
    }

    // 3，根据ID从数据库中删除一个商品
    public void delete(int id) throws SQLException {
        // 删除操作
        String sql = "delete from goods where id=?";
        // 执行
        qr.update(sql,id);
    }
    // 4，传入一个商品，从数据库中根据ID更新该商品
    public void update(Goods goods, int id) throws SQLException {
        // 更新操作
        String sql = "update goods set name=?,price=?,image=?,descr=?,is_hot=?,cid=? where id=?";
        qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getDescr(),goods.getIs_hot(),goods.getCid(),id);
    }

    public Long getCount() throws SQLException {
        String sql="select count(*) from goods";
        Long count = (Long) qr.query(sql,new ScalarHandler());
        return count;
    }

    public List<Goods> getPageDate(Integer index, Integer pageCount) throws SQLException {
        String sql="select * from goods order by id desc limit ?,?";
        List<Goods> pagegoods = null;
        pagegoods=qr.query(sql,new BeanListHandler<Goods>(Goods.class),index,pageCount);
        return pagegoods;
    }
}
