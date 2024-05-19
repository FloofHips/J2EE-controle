package ma.formations.jpa.service;

import java.util.List;
import ma.formations.jpa.dao.DaoImplJPA;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.dao.article.ArticleDaoImplJPA;
import ma.formations.jpa.dao.article.IArticleDao;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public class ServiceImpl implements IService {
	private IDao dao = new DaoImplJPA();
	private IArticleDao daoArticle = new ArticleDaoImplJPA();

	@Override
	public Boolean checkAccount(String username, String password) {
		User u = dao.getUserByUsername(username);
		if (u == null)
			return false;
		return (password.equals(u.getPassword()));
	}

	@Override
	public List<Article> getAllArticle() {
		return daoArticle.findAll();
	}
	
	@Override
	public Article getArticlebyId(long Id) {
		Article a = daoArticle.findById(Id);
		if(a!=null)
			return a;
		return null;
	}
	
	public void createArticle(Article article) {
		daoArticle.save(article);
	}
	
	public void editArticle(Article article) {
		daoArticle.save(article);
	}
	
	public void deleteArticle(long Id) {
		daoArticle.delete(Id);
	}


	public Boolean checkIfExists(String username) {
		User u = dao.getUserByUsername(username);
		return (u != null);
	}
	
	@Override
    public void register(User user) {
		dao.save(user);
    }

	@Override
	public String getHashedPassword(String username) {
		User u = dao.getUserByUsername(username);
		String hashedPassword = u.getPassword();
		if(hashedPassword!=null)
			return hashedPassword;
		return null;
	}

	@Override
	public void updatePassword(String username, String password) {
		User u = dao.getUserByUsername(username);
		u.setPassword(password);
		dao.save(u);
	}
}