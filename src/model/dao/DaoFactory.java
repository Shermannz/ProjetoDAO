package model.dao;

import db.DB;
import model.dao.ipl.DepartmentDaoJDBC;
import model.dao.ipl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.GetConnection());
	}
	
	public static DepartmentDao createdepartmentDao() {
		return new DepartmentDaoJDBC(DB.GetConnection());
	}
	
}
