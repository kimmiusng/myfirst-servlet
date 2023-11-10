package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication-string-servlet")
public class MultiplicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int num = Integer.parseInt(req.getParameter("num"));
        out.println(num + " 단\n");

        for (int i = 1; i <= 9; i++){
            out.println();
            out.println(num + " * " + i + " = " + (num*i));
        }
    }
}

//get으로 다시 해보기!