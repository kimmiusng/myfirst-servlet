package com.kitri.myfirstservlet.state;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher1") //이름은 생략하고 value 값만 넣을 수도 있음
public class DispatcherServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h3> Dispatcher1 수행 결과 </h3>");

        // forward (전달) -> 분업화 된 다른 서블릿을 호출하고 싶을 때 사용("서버 내부적으로 : forward와 include를 사용")
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
//        rd.forward(req, resp); // forward 할 때는, 요청(req)와 응답(resp)를 함께 넣어 주어야 한다
//        rd.include(req, resp);
        //dispatcher2에 갔다가 그 곳의 요청사항을 다시 가져와 포함시켜버리는 결과
        //"Dispatcher1 수행 결과"와 "Dispatcher2 수행 결과" 두 가지 모두 출력됨

        req.setAttribute("name", "키트리");
        rd.forward(req, resp);


    }
}
