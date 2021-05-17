package com.qcby.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class roomInsertServlet
 */
@WebServlet("/roomInsertServlet")
public class roomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomInsertServlet() {
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
	response.setContentType("application/json;charset=utf-8 ");
	request.setCharacterEncoding("utf-8");
	
	String room_idString = request.getParameter("room_id");
	String order_nameString = request.getParameter("order_name");
	String order_telString = request.getParameter("room_tel");
	String tipsString =request.getParameter("tips");
	String sqlString = "insert into order_room(room_id,order_name,order_tel,tips)values('"+room_idString+"','"+order_nameString+"','"+order_telString+"','"+tipsString+"');";
	MysqlUtil.add(sqlString);
	String  json="{\"code\":200,\"message\":\"插入成功\"}";
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
