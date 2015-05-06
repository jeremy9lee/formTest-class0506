package com.sds.icto.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/table")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TableServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String row = request.getParameter("a");
		String col = request.getParameter("b");

		int nRow;
		int nCol;

		if (row != null) {
			nRow = Integer.parseInt(row);
		} else {
			nRow = 3;
		}

		if (col != null) {
			nCol = Integer.parseInt(col);
		} else {
			nCol = 3;
		}
		
		PrintWriter out = response.getWriter();
		out.print("<table border = '1px'  cellspacing = '0' cellpadding = '10px'>");

		for (int i = 0; i < nRow; i++) {
			out.print("<tr>");
			for (int j = 0; j < nCol; j++) {
				out.print("<td>cell(" + i + "," + j + ")</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
	}

}
