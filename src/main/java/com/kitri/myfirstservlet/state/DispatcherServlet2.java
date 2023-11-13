package com.kitri.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher2")
public class DispatcherServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h3> Dispatcher2 수행 결과 </h3>");
        out.println(req.getAttribute("name"));
        // dispatcher1에서 저장해 둔 것을 forward 후,
        // dispatcher2에서 req.getAttribute로 가져와서 출력
        out.close();

    }
}
