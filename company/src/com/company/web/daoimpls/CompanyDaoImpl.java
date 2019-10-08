package com.company.web.daoimpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.web.daos.CompanyDao;
import com.company.web.domains.EmployeeBean;
import com.company.web.enums.Vendor;
import com.company.web.factory.DatabaseFactory;

public class CompanyDaoImpl implements CompanyDao{
	private static CompanyDaoImpl instance = new CompanyDaoImpl();
	
	public static CompanyDaoImpl getInstance() {
		return instance;
	}
	private CompanyDaoImpl() {}

	@Override
	public boolean insertEmployee(EmployeeBean param) {
		System.out.println(7);
		boolean result = false;
		System.out.println(param);
		String sql = "INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?)"; 
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(String.valueOf(Vendor.ORACLE)).getConnection().prepareStatement(sql);
			pstmt.setString(1,param.getEmpNo());
			pstmt.setString(2,param.getEname());
			pstmt.setString(3,param.getJob());
			pstmt.setString(4,param.getMgr());
			pstmt.setString(5,param.getHireDate());
			pstmt.setString(6,param.getSal());
			pstmt.setString(7,param.getComm());
			pstmt.setString(8,param.getDeptNo());
			int rs = pstmt.executeUpdate();
			result = (rs==1) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public EmployeeBean selectByEmpnoEname(EmployeeBean param) {
		EmployeeBean emp = null;
		String sql="SELECT EMPNO,\r\n" + 
				"       ENAME,\r\n" + 
				"       JOB,\r\n" + 
				"       MGR,\r\n" + 
				"       HIREDATE,\r\n" + 
				"       SAL,\r\n" + 
				"       COMM,\r\n" + 
				"       E.DEPTNO\r\n" + 
				"FROM EMP E \r\n" + 
				"    JOIN DEPT D \r\n" + 
				"        ON E.DEPTNO LIKE D.DEPTNO\r\n" + 
				"WHERE EMPNO LIKE ?\r\n" + 
				"    AND ENAME LIKE ?\r\n" + 
				"    AND E.DEPTNO LIKE ?";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(String.valueOf(Vendor.ORACLE)).getConnection().prepareStatement(sql);
			System.out.println("파람 값 보기 \n");
			System.out.println(param.toString());
			pstmt.setString(1,param.getEmpNo());
			pstmt.setString(2,param.getEname());
			pstmt.setString(3,param.getDeptNo());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				emp = new EmployeeBean();
				emp.setEmpNo(rs.getString("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setMgr(rs.getString("MGR"));
				emp.setHireDate(rs.getString("HIREDATE"));
				emp.setSal(rs.getString("SAL"));
				emp.setComm(rs.getString("COMM"));
				emp.setDeptNo(rs.getString("DEPTNO"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(emp == null) {
			System.out.println("emp 가 널이다 !! ");
		}else {
			System.out.println("emp 가 널 아님");
		}
		
		
		return emp;
	}

}
