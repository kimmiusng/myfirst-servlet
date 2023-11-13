package com.kitri.myfirstservlet.state;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "stateStoreServlet", value = "/state-store")
public class StateStoreServlet extends HttpServlet {

    int memberCount = 0; //필드(멤버 변수)
    //톰캣을 돌리면 새로 고침을 할 때 마다+1씩 증가
    //객체가 생성 되고 나서 계속 유지되기 때문에
    ServletContext servletContext = null;

    HashMap<HttpSession, Integer> users = new HashMap<>(); //방문자 세션을 기록하는 실습


    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1. ServletContext : WAS 시작 WAS 종료
        // 서블릿을 담고 있는 최종 객체?
        // 서블릿 컨텍스트는 서버가 시작하고나서 끝날때까지 저장이 됨, 범위가 가장 넓음
        // count 수 계속 증가 가능

        servletContext = config.getServletContext(); //서블릿 컨텍스트를 가지고 오는 첫번째 방법
        servletContext.setAttribute("count", new Integer(0));
    }
    //init()은 서블릿이 최초 생성될 때 1번 실행

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int localCount = 0; //지역 변수 -> 톰캣을 돌리면 계속 1이 나옴

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("멤버 카운트 : " + ++memberCount);
        out.println("로컬 카운트 : " + ++localCount);

        // ServletContext
        int applicationCount = (int) servletContext.getAttribute("count");
        servletContext.setAttribute("count", ++applicationCount);
        out.println("애플리케이션 단위 카운트 : " + applicationCount);

        //this.getServletContext();
        //서블릿 컨텍스트를 가지고 오는 두번째 방법
        //this는 stateStoreServlet이고, HttpServlet을 상속받았고,
        //그 안에 config ...등등 다 불러올 수 있는 것이 있다고 함


        // 2. Session : 클라이언트의 요청~클라이언트의 종료
        HttpSession session = req.getSession(); // 세션 ID를 가지고 올 수 있음
        if (session.isNew()) {
            out.println("세션 생성 완료" + session.getId());
        }
        Integer sessionCount = (Integer) session.getAttribute("count");  // session.isNew(); 세션이

        if (sessionCount == null) {
            sessionCount = 0;
            session.setAttribute("count", sessionCount);   // 여기까지는 sessionCount 초기화 작업
        }
        session.setAttribute("count", ++sessionCount);
        out.println("세션 단위 카운트 : " + sessionCount);  //크롬이랑 엣지랑 카운트가 달라짐, 세션 단위로 초기화 됨(유지 범위?)


        out.println("----해당 페이지에 접속한 유저별 방문 횟수----");
        users.put(session, sessionCount);
        users.forEach((key, value) -> {
            out.println(key + " : " + value);

        });
    }
}


