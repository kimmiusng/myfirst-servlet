package com.kitri.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", value = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 쿠키 : 클라이언트 측에 저장
        // (상태 정보를 저장하는 기술)
        // 서버에 접속할 때 자동으로 요청에 포함되어 전달
//        new Cookie("id", "guest");
//        resp.addCookie(new Cookie("id", "guest"));
                       // ▲ 쿠키 객체를 넣어주면 된다

        Cookie cookie1 = new Cookie("id", "guest");
        cookie1.setMaxAge(60*60*24);
        resp.addCookie(cookie1);   //쿠키의 만료일을 지정할 수 있다

        Cookie cookie2 = new Cookie("code", "007");
        cookie2.setPath("/cookie-read");  //쿠키의 경로를 지정할 수 있다.
        resp.addCookie(cookie2);

        out.println("쿠키 전송 완료");

    }
}
