package dao;

import bean.Blog;
import bean.Reponse;
import bean.Utilisateur;

import java.sql.SQLException;
import java.util.List;


public interface IBlogDao {

	Blog getBlog(Integer id);
	List<Blog> getBlogs(Utilisateur utilisateur);
	Integer createBlog(Blog blog) throws SQLException;
	void updateBlog(Blog blog) throws SQLException;
	void deleteBlog(Blog blog) throws SQLException;
	void addReponse(Blog blog, Reponse reponse) throws SQLException;
	
}
