package com.kitri.myfirstservlet.practice;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet(name = "Calculation", value = "/")
public class Calculation extends HttpServlet {
}


//상대경로 vs 절대경로 개념