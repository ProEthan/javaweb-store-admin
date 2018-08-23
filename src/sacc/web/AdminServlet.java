package sacc.web;

import sacc.domain.Admin;
import sacc.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminServlet")
public class AdminServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用登录业务
        AdminService adminService = new AdminService();
        Admin admin=null;
        try {
            admin = adminService.get(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(admin != null){
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            resp.sendRedirect("main_page.jsp");
        }
        else{
            resp.setHeader("login_error", "error");
            //4.转发到商品列表页面，转发时把request对象传入
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
