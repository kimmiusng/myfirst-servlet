package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


@WebServlet(name = "Join", value = "/join")
public class JoinServlet extends HttpServlet {
    static ServletContext sc = null;
    HashMap<String, User> user = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
       sc = config.getServletContext(); //저장 객체 단위
        //sc.setAttribute(id,id);
        //sc.getAttribute(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String pw1 = req.getParameter("pw1");
        String pw2 = req.getParameter("pw2");




        if (sc.getAttribute(id) == null) {
            if (pw1.equals(pw2)) {
                sc.setAttribute(id, new User(id, pw1));
                out.println("회원가입에 성공하셨습니다.");
                out.println("<hr><a href=practice/loginOut.html>로그인 화면으로 바로가기</a></hr>");
            } else {
                out.println("비밀번호가 일치하지 않습니다.");
                out.println("<hr><a href=practice/join.html>회원가입으로 돌아가기</a></hr>");
            }
        } else {
            out.println("이미 존재하는 아이디입니다.");
            out.println("<hr><a href=practice/join.html>회원가입으로 돌아가기</a></hr>");
        }
    }
}
