package yk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yk.dao.BaseDao;
import yk.po.TX;


@SuppressWarnings("serial")
public class KaiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseDao bd =new BaseDao();
		//bd.query();
		//bd.queryParam(tx);
		//bd.deleteOne(25);
		/*List<Integer> list=new ArrayList<Integer>();
		list.add(33);
		list.add(32);
		bd.deleteBatch(list);*/
		TX tx=new TX();
		tx.setName("¿¨¿¨");
		tx.setId(14);
		bd.queryWhere(tx);
	}


}
