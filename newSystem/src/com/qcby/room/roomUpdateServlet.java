package com.qcby.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcby.mysql.MysqlUtil;

/**
 * Servlet implementation class roomUpdateServlet
 */
@WebServlet("/roomUpdateServlet")
public class roomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomUpdateServlet() {
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
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
	
		String idString = request.getParameter("room_id");
		String nameString = request.getParameter("order_name");
		String telString = request.getParameter("order_tel");
		String tipsString = request.getParameter("tips");
		String sqlString = "update order_room set order_name='"+nameString+"',order_tel='"+telString+"',tips='"+tipsString+"' where room_id="+idString+" ";
		String json = " ";
		int res = MysqlUtil.update(sqlString);
		if(res==1) {
			json = "{\"code\":\"200\",\"message\":\"修改成功\"}";
		}else {
			json = "{\"code\":\"200\",\"message\":\"修改失败\"}";
		}
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
