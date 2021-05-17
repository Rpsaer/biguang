package com.qcby.coding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	response.setCharacterEncoding("utf-8");
	response.setContentType("application/json; charset=utf-8");
	request.setCharacterEncoding("utf-8");
	String userNameString = request.getParameter("userName");
	String passwordString = request.getParameter("password");
	System.out.println(userNameString+" " +passwordString );
	String sqlString = "select * from userlogin where userName='"+userNameString+"'and password='"+passwordString+"';";
	String[] colums = {"userName","password"};
	ArrayList<String[]> res = MysqlUtil.showUtil(sqlString, colums);
	String json = "{\"code\":"+res.size()+",\"meg\":\"\"}";
	response.getWriter().write(json);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
