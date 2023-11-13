package com.kitri.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet (name = "userVisitServlet", value = "/userVisit")
public class UserVisitServlet extends HttpServlet {

    HashMap<HttpSession, User> users = new HashMap<>(); //세션별 유저의 정보를 담는다

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");   // <-한글 깨짐 방지
        PrintWriter out = resp.getWriter();


        //유저의 세션을 가져 온다
        HttpSession session = req.getSession();
        if (!users.containsKey(session)){
            User user = new User();
            user.setName(req.getParameter("name"));
            user.setCity(req.getParameter("city"));
            user.setCount(0);
            users.put(session, user);
            // 세션에 등록되어 있지 않은경우 (▲ 최초 방문일 경우)

        }

        // ▼ 재방문일 경우
        User user = users.get(session);
        user.setCount(user.getCount() + 1);

        //forEach로 반복작업(람다표현식)
        users.forEach((key, value)-> {
            out.println(value);
        });
    }
}
