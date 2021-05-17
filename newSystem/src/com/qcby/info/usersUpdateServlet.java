package com.qcby.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class usersUpdateServlet
 */
@WebServlet("/usersUpdateServlet")
public class usersUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName = request.getParameter("userName");
		String liveString = request.getParameter("live_time");
		String phoneNumberString = request.getParameter("phoneNumber");
		String roomString = request.getParameter("room");
		String idCardString = request.getParameter("idCard");
		String idString =request.getParameter("id");
		String flagString ="0";
		System.out.println(userName +"  " + liveString +"  "+ phoneNumberString + "  "+ idString);
		String json = " ";
		String sqlString="update users set userName='"+userName+"',live_time='"+liveString+"',phoneNumber='"+phoneNumberString+"',room='"+roomString+"',idCard='"+idCardString+"',flag='"+flagString+"' where id="+idString+" ";
		System.out.println(sqlString);
		int count = MysqlUtil.update(sqlString);
		if(count==1) {
		  json="{\"code\":200,\"message\":\"修改成功\"}";
		}else {
			 json="{\"code\":200,\"message\":\"修改失败\"}";
		}
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
