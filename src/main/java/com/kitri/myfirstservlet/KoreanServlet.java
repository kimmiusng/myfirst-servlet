package com.kitri.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//1. 클래스 생성
//2. HttpServlet을 상속
//3. @어노테이션 등록 > value값은 주소 url이라고 생각하면 됨!
//4. Service로 오버라이딩


@WebServlet(name = "koreanServlet", value = "/korean-servlet")
public class KoreanServlet extends HttpServlet {
    // 클라이언트에 문자열로 응답 -> 출력 스트림

    private String message;
    public void init(){ message = "안녕하세요";}

    @Override //service(Hettp버전으로 오버라이딩)
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트에 문자열로 응답 -> 출력 스트림
        resp.setContentType("text/html;charset=UTF-8");
        //MIME 타입 구조; type/subtype;parameter=value
        //내가 보내는 내용의 TPYE을 지정 / 한글 타입 지정은 ;charset=UTF-8 추가

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message +"</h1>");
    }
}
