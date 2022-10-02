package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.Criminal_InfoExcetion;
import com.Utility.DBUtil;
import com.bean.Criminal_Info;

public class Criminal_crimeDAOImol implements Criminal_crimeDAO {

	@Override
	public List<Criminal_Info> CrimeFile(String cname) throws Criminal_InfoExcetion {
		List<Criminal_Info> Criminals= new ArrayList<>();


		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select c.cname, cr.crime_name from criminal"
					+ " c INNER JOIN criminfo cr INNER JOIN criminal_crime ccr ON ccr.crimId=cr.crimId "
					+ "AND ccr.cid=c.cid AND cr.crime_name=?");
			ps.setString(1,cname );
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				
     Criminal_Info cri=new Criminal_Info();
			cri.setName(	rs.getString("cname"));
			cri.setCrime_Name(rs.getString("Crime_name"));
     
	    Criminals.add(cri);
	
			}
			} catch (SQLException e) {
				throw new Criminal_InfoExcetion(e.getMessage());
				
			}
			
			
			if(Criminals.size() == 0)
				throw new Criminal_InfoExcetion("No Criminal crime found..");
			
			
			
			
			return Criminals;
	
	}

}
