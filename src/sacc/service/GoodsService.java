package sacc.service;

import sacc.dao.GoodsDao;
import sacc.domain.Goods;
import sacc.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {
    public Goods get(int id) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(id);
        return goods;
    }

    public List<Goods> getAllGoods() throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        return goodsDao.getAll();
    }

    public void delete(String id) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        goodsDao.delete(Integer.parseInt(id));
    }

    public void save(Goods goods) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        goodsDao.save(goods);
    }

    public void update(Goods goods, int id) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        goodsDao.update(goods, id);
    }

    public PageBean getPageBean(Integer currentPage) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        PageBean pageBean = new PageBean();
        // 设置当前页
        pageBean.setCurrentPage(currentPage);
        // 共有多少条记录
        Long count = goodsDao.getCount();
        pageBean.setTotalCount(count.intValue());
        // 一页多少条数据
        Integer pageCount = 5;
        // 总页数
        double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
        pageBean.setTotalPage((int)totalPage);
        // 当前页查询的角标
        Integer index =(pageBean.getCurrentPage() - 1) * pageCount;
        // 当前页商品
        List<Goods> list = goodsDao.getPageDate(index,pageCount);
        pageBean.setGoodsList(list);

        return pageBean;
    }
}
