package sacc.service;

import sacc.dao.AdminDao;
import sacc.domain.Admin;

import java.sql.SQLException;

public class AdminService {
    public Admin get(String username, String password) throws SQLException {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.get(username,password);
        if(admin != null){
            return admin;
        }
        else{
            return null;
        }
    }
}
