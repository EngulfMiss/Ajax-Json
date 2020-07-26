package com.Engulf.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的数据格式为json
        response.setContentType("application/json;charset=utf-8");

        //response.setContentType("text/html;charset=utf-8");
        //1.获取用户名
        String username = request.getParameter("username");
        //2.调用service层判断用户名是否存在

        //期望服务器响应的数据格式是json:{"userExist":true,"msg":"用户名已被注册"} -- 存在
        //                             {"userExist":false,"mas":"用户名可用"}  --  不存在


        Map<String,Object> map = new HashMap<String,Object>();
        if("tom".equals(username)){
            //存在
            map.put("userExist",true);
            map.put("msg","用户名已被注册");
        }else {
            // 不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");

        }

        //将map转换为json
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
