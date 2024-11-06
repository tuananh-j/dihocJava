package com.poly.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.dao.UserImpl;
import com.poly.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/user/index","/user/edit/*","/user/create","/user/update","/user/delete","/user/reset"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User form = new User();
		try {
			BeanUtils.populate(form, request.getParameterMap());
		}catch(IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		UserDao dao = new UserImpl();
		String path = request.getServletPath();
		
		
		if(path.contains("edit")) {
			String id = request.getPathInfo().substring(1);
			form = dao.find_id(id);
		}else if(path.contains("create")) {
			try {
				dao.create(form);
				form = new User();
				request.setAttribute("message", "tao thanh con");
			}catch(RuntimeException e) {
				request.setAttribute("message", "trung khoa chinh");
			}
			
		}else if(path.contains("update")) {
			dao.update(form);
		}else if(path.contains("delete")) {
			dao.delete_id(form.getId());
			form = new User();
		}else {
			form = new User();
		}
		request.setAttribute("item", form);
		List<User> list = dao.find_all();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/User.jsp").forward(request, response);
	}


	

}
