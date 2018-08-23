package sacc.web;

import org.apache.commons.beanutils.BeanUtils;
import sacc.domain.Category;
import sacc.domain.Goods;
import sacc.domain.PageBean;
import sacc.service.CategoryService;
import sacc.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
    private String currentPage;

    public String getPageDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean pageBean = null;
        try {
            // 获取当前页码
            currentPage = req.getParameter("currentPage");
            // 把页码给业务层，根据页码给我一个pageBean
            GoodsService goodsService = new GoodsService();
            pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
            // 把pageBean写到域中
            req.setAttribute("pageBean",pageBean);
            // 转发
            return "/main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 调用服务层
        GoodsService goodsService = new GoodsService();
        try {
            List<Goods> allGoods = goodsService.getAllGoods();
            // 对集合进行反转
            Collections.reverse(allGoods);
            // 把数据写道request域中
            req.setAttribute("allGoods", allGoods);
            return "/main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 调用服务层
        GoodsService goodsService = new GoodsService();
        String id = req.getParameter("id");
        try {
            goodsService.delete(id);
            return "/GoodsServlet?action=getPageDate&currentPage="+currentPage;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取所有参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 把参数封装成对象
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
            goods.setImage("goods_002.png");
            // 调用服务层
            GoodsService goodsService = new GoodsService();
            goodsService.save(goods);
            return "/GoodsServlet?action=getPageDate&currentPage=1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String addUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CategoryService categoryService = new CategoryService();
        try {
            List<Category> allCate = categoryService.findCategory();
            // 存放再域中
            req.setAttribute("allCategory",allCate);
            // 转发到add.jsp
            return "/add.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取所有参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 把参数封装成对象
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods,parameterMap);
            goods.setImage("goods_002.png");
            // 根据id更新数据
            String id=req.getParameter("id");
            // 调用服务层
            GoodsService goodsService = new GoodsService();
            goodsService.update(goods,Integer.parseInt(id));
            // 跳转
            return "/GoodsServlet?action=getPageDate&currentPage="+currentPage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String editUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取当前商品的id
        String id = req.getParameter("id");
        // 获取当前商品
        GoodsService goodsService = new GoodsService();
        Goods goods = null;
        // 获取所有的分类
        CategoryService categoryService = new CategoryService();
        try {
            goods = goodsService.get(Integer.parseInt(id));
            // 存放在域中
            req.setAttribute("goods",goods);

            List<Category> allCate = categoryService.findCategory();
            // 存放再域中
            req.setAttribute("allCategory",allCate);

            return "/edit.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}