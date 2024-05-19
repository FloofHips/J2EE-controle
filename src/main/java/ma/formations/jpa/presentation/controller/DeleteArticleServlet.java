package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;

@WebServlet("/deleteArticle.do")
public class DeleteArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String articleIdString = request.getParameter("id");
        if (articleIdString != null) {
            long articleId = Integer.parseInt(articleIdString);
            service.deleteArticle(articleId);
        }
        response.sendRedirect(request.getContextPath() + "/articles.do");
    }
}
