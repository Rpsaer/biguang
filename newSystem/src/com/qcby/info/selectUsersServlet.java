package com.qcby.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class selectUsersServlet
 */
@WebServlet("/selectUsersServlet")
public class selectUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json ;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"))-1;
		int limit = Integer.parseInt(request.getParameter("limit"));
		String sqlString = "select * from users where flag='0' ";
		if(limit!=0) {
			if(page!=0) {
				sqlString +=" limit "+limit*page+","+limit;
			}else {
				sqlString +=" limit 0,"+limit;
			}
		}
		
		String[]  colums = {"id","userName","live_time","phoneNumber","room","idCard","flag"};
		String jsonString = MysqlUtil.getJsonBySql(sqlString, colums);
		System.out.println(jsonString);
		response.getWriter().write(jsonString);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
