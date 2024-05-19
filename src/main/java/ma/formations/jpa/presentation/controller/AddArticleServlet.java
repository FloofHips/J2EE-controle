package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Article;

@WebServlet("/addarticle.do")
public class AddArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-article.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String description = request.getParameter("description");
        String quantiteStr = request.getParameter("quantite");
        String priceStr = request.getParameter("price");

        boolean hasErrors = false;

        if (description == null || description.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Description cannot be empty.");
            hasErrors = true;
        }

        Double quantite = null;
        if (quantiteStr == null || quantiteStr.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Quantité cannot be empty.");
            hasErrors = true;
        } else {
            try {
                quantite = Double.parseDouble(quantiteStr);
                if (quantite <= 0) {
                    request.setAttribute("errorMessage", "Quantité must be a positive number.");
                    hasErrors = true;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Quantité must be a valid number.");
                hasErrors = true;
            }
        }

        Double price = null;
        if (priceStr == null || priceStr.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Price cannot be empty.");
            hasErrors = true;
        } else {
            try {
                price = Double.parseDouble(priceStr);
                if (price <= 0) {
                    request.setAttribute("errorMessage", "Price must be a positive number.");
                    hasErrors = true;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Price must be a valid number.");
                hasErrors = true;
            }
        }
        
        if (hasErrors) {
            Article article = new Article();
            article.setDescription(description);
            article.setQuantite(quantite);
            article.setPrice(price);
            request.setAttribute("article", article);
            request.getRequestDispatcher("/view/add-article.jsp").forward(request, response);
            return;
        }
        
        
        Article article = new Article();
        article.setDescription(description);
        article.setQuantite(quantite);
        article.setPrice(price);

        service.createArticle(article);

        response.sendRedirect(request.getContextPath() + "/articles.do");
    }
}