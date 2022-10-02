package com.Usecases;

import java.util.Scanner;

import com.DAO.CriminalDAo;
import com.DAO.CriminalaDAOImpl;
import com.bean.Criminal_Info;

public class DelectCriminalUsecase {

public static void DeleteCriminal() {
		
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the Cid: ");
		int id=sc.nextInt();
		
		CriminalDAo dao=new CriminalaDAOImpl();

		Criminal_Info criminal=new Criminal_Info();
	
		criminal.setCid(id);
		
      String result= dao.DeleteCriminal(criminal);
		
		System.out.println(result);
		
		
	}
	
}
