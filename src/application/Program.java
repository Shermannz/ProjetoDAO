package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);

		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println("\n==== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: Seller findAll ====");
		 list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4: Seller Insert ====");
        Seller newSeller = new Seller(null, "Greg","greg@gmmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
	
		System.out.println("\n==== TEST 5: Seller Update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated completed");
		
        System.out.println("\n==== TEST 6: Seller Delete ====");
		System.out.print("Enter id for delete id: ");
		int id = entrada.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		entrada.close();
	}
}
