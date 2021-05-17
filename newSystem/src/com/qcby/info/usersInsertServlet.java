package com.qcby.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class usersInsertServlet
 */
@WebServlet("/usersInsertServlet")
public class usersInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String userNameString = request.getParameter("userName");
		String liveString = request.getParameter("live_time");
		String phoneNumberString = request.getParameter("phoneNumber");
		String roomString = request.getParameter("room");
		String idCardString = request.getParameter("phoneNumber");
		System.out.println(userNameString + " " +liveString+" "+phoneNumberString );
		String sql = "insert into users(userName,live_time,phoneNumber,room,idCard)values('"+userNameString+"','"+liveString+"','"+phoneNumberString+"','"+roomString+"','"+idCardString+"');";
		MysqlUtil.add(sql);
			String  json="{\"code\":200,\"message\":\"插入成功\"}";
		response.getWriter().append(json);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
