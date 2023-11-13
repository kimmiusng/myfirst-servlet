package com.kitri.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestServlet", value = "/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 : HttpServletRequest 객체 생성
        // 응답 : HttpServletRequest 객체 소멸
        String site = req.getParameter("site");

        if (site.equals("naver")){
            //네이버로 이동(리다이렉트(재지정)->페이지를 넘긴다)
            resp.sendRedirect("http://www.naver.com"); //프로토콜도 함께 지정해주어야 함
        } else if (site.equals("google")){
            resp.sendRedirect("http://www.google.com");
        } else if (site.equals("daum")){
            resp.sendRedirect("http://www.daum.net");
        }
    }
}
