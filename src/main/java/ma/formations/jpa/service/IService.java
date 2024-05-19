package ma.formations.jpa.service;

import java.util.List;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public interface IService {
	Boolean checkAccount(String username, String password);

	List<Article> getAllArticle();
	
	Article getArticlebyId(long Id);
	
	void createArticle(Article article);
	
	void editArticle(Article article);
	
	void deleteArticle(long Id);

	Boolean checkIfExists(String username);
	
	String getHashedPassword(String username);

	void register(User user);
	
	void updatePassword(String username, String password);
}