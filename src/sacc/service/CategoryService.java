package sacc.service;

import sacc.dao.CategoryDao;
import sacc.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    public List<Category>  findCategory() throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.getAll();
    }
}
