package com.kitri.myfirstservlet.practice;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

import static com.kitri.myfirstservlet.practice.JoinServlet.sc;

@WebServlet(name = "loginOut", value = "/loginOut")
public class LoginOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        Object obj1 = sc.getAttribute("user");
        HashMap<String, User> user = (HashMap<String, User>) obj1;

        HttpSession session = req.getSession();


        if (session.getAttribute("sessionId") == null) {
            if (user.containsKey(id)) {
                if (pw.equals(user.get(id).getPassword())) {
                    out.println("로그인 성공했습니다.");
                    session.setAttribute("sessionId", user);
                    out.println("<hr><a href=practice/loginOut.html>로그인 화면으로 돌아가기</a><hr>");
                } else {
                    out.println("비밀번호가 틀렸습니다.");
                    out.println("<hr><a href=practice/loginOut.html>로그인 화면으로 돌아가기</a><hr>");
                }
            } else {
                out.println("해당 회원 아이디는 존재하지 않습니다.");
                out.println("<hr><a href=practice/loginOut.html>로그인 화면으로 돌아가기</a><hr>");
            }
        } else {
            out.println("현재 로그인 상태입니다.");
        }
    }



        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=UTF-8");
            req.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            HttpSession session = req.getSession();
            if (session.getAttribute("sessionId") != null) {
                session.invalidate();
                out.println("로그아웃 되었습니다.");
            } else {
                out.println("현재 로그인 상태가 아닙니다.");
            }
            out.close();
        }
    }

//세션 제거하는 거
//session.removeAttribute(id);
//session.invalidate();


