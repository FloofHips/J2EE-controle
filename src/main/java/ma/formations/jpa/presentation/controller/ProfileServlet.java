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

@WebServlet("/profile.do")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            String hashedCurrentPassword = hashPassword(currentPassword);
            if (service.checkAccount(username, hashedCurrentPassword)) {
                String hashedNewPassword = hashPassword(newPassword);
                service.updatePassword(username, hashedNewPassword);
                request.setAttribute("successMessage", "Password updated successfully!");
            } else {
                request.setAttribute("errorMessage", "Current password is incorrect.");
            }
        } else {
            request.setAttribute("errorMessage", "New passwords do not match.");
        }
        request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
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
