package com.DAO;

import java.util.List;

import com.Exception.Criminal_InfoExcetion;
import com.bean.Criminal_Info;

public interface Criminal_crimeDAO {

	public List<Criminal_Info>  CrimeFile(String cname)  throws Criminal_InfoExcetion;
	
}
