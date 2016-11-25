package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserManager;
import model.User;

@WebServlet(name = "LoginAdminServlet", urlPatterns = { "/LoginAdminServlet" })
public class LoginAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session=req.getSession();

		String loginName=req.getParameter("LoginName");
		String passWord=req.getParameter("PassWord");

		UserManager um=new UserManager();
//		User user=new User();
//		user.setLoginName(loginName);
//		user.setPassWord(passWord);
//		user.setName("Mr.x");
		User user=um.getUserAdmin(loginName,passWord);

		req.setAttribute("User", user);
		req.getRequestDispatcher("TopAdmin.jsp").forward(req, res);


	}
}
