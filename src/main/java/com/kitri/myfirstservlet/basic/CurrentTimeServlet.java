package com.kitri.myfirstservlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.time.LocalTime.now;
//1. 클래스 생성
//2. HttpServlet을 상속
//3. 보통 doGet으로 "text/html"작성
//3. @어노테이션 등록 > value값은 주소 url이라고 생각하면 됨!
// <a href="currentTime-servlet">현재 시간 여기가 화면에 보여지는 곳</a> index.jsp에도 value값과 동일하게 작성해주어야한다

@WebServlet(name = "currentTime", value = "/currentTime-servlet")
public class CurrentTimeServlet extends HttpServlet {
    private String message;

    public void init(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        message = "" + simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}

