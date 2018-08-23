package sacc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取参数类型
        String action=req.getParameter("action");
        // 获取当前的字节码
        Class clazz=this.getClass();

        try {
            // 根据参数名称获取方法名称
            Method method=clazz.getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            if(method != null){
                String dpath=(String)method.invoke(this,req,resp);
                if (dpath != null){
                    req.getRequestDispatcher(dpath).forward(req,resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}