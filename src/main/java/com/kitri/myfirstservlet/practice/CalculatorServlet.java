package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorServlet", value = "/calculator-string-servlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int val1 = Integer.parseInt(req.getParameter("val1"));
        int val2 = Integer.parseInt(req.getParameter("val2"));
        String op = req.getParameter("op");

        switch (op){
            case "plus":
                out.println("<p>" + val1 + " + " + val2 + " = " + (val1+val2) + "</p>");
                break;
            case "minus":
                out.println("<p>" + val1 + " - " + val2 + " = " + (val1-val2) + "</p>");
                break;
            case "mul":
                out.println("<p>" + val1 + " * " + val2 + " = " + (val1*val2) + "</p>");
                break;
            case "div":
                out.println("<p>" + val1 + " / " + val2 + " = " + (val1/val2) + "</p>");
                break;
            case "mod":
                out.println("<p>" + val1 + " % " + val2 + " = " + (val1%val2) + "</p>");
                break;
        }
    }
}


