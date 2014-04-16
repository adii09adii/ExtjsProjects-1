package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComboBoxServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ComboBoxServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		//起始索引
		int start=Integer.parseInt(request.getParameter("start"));
		//页大小
		int limit=Integer.parseInt(request.getParameter("limit"));
		System.out.println(start+","+limit);
		//总记录条数，如果是数据库则通过Count计算
		int totalProperty=17;
		String fmt="{did:%d,dname:'%s'}";
		StringBuffer s=new StringBuffer("{totalProperty:");
		s.append(totalProperty).append(",root:[");
		int end=start+limit;
		//因为不是查找数据库，所以需要多加一个判断
		if(end>totalProperty)end=totalProperty;
		for(int i=start;i<end;i++)
		{
			s.append(String.format(fmt, i,"部门"+i));
			if(i<end-1)
			{
				s.append(",");
			}
		}
		s.append("]}");
		out.println(s.toString());
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
