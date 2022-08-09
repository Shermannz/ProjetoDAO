package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
      DepartmentDao dd = DaoFactory.createdepartmentDao();
      Department dd2 = dd.findById(1);
      System.out.println("Funfou");
      dd.findById(1);
      System.out.println(dd2);
		
		
	}
}
