package com.qcby.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class roomSelectServlet
 */
@WebServlet("/roomSelectServlet")
public class roomSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomSelectServlet() {
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
		response.setContentType("application/json ; charset= utf-8");
		request.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"))-1;
		int limit = Integer.parseInt(request.getParameter("limit"));
		String sqlString = "select * from order_room ";
		if(limit!=0) {
			if(page!=0) {
				sqlString +=" limit "+limit*page+","+limit;
			}else {
				sqlString +=" limit 0,"+limit;
			}
		}
		String[] colums = {"room_id","order_name","order_tel","tips"};
		String jsonString = MysqlUtil.getJsonBySql(sqlString, colums);
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
