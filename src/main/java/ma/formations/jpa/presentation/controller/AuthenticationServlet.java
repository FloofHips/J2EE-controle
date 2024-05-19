package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;

@WebServlet("/login.do")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IService service = new ServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hashedPassword = hashPassword(password);
		String hashedPasswordFromDB = service.getHashedPassword(username);
		
		if (!service.checkAccount(username, hashedPassword)) {
			request.setAttribute("AccountIncorrect", "Login or password incorrect !");
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/view/main-template.jsp").forward(request, response);
		}
	}
	
	private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password.", e);
        }
    }
}