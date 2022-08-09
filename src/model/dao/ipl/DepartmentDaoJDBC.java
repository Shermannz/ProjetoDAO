package model.dao.ipl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbExcepion;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into department(Name) values (?)");
			st.setString(1, obj.getName());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new db.DbExcepion(e.getMessage());
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department SET Name = ? where id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new db.DbExcepion(e.getMessage());
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from department where id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new db.DbExcepion(e.getMessage());
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("select * from department where id = ?;");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Department dd = new Department();
				dd.setId(rs.getInt("Id"));
				dd.setName(rs.getString("Name"));
				return dd;
			}
		}catch(SQLException e) {
			throw new db.DbExcepion(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * from department");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Department dep = new Department();
			    dep.setId(rs.getInt("Id"));
			    dep.setName(rs.getString("Name"));
			    list.add(dep);
				
				
			}
			return list;
		}catch(SQLException e) {
			throw new DbExcepion(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	
	
}
