package com.masai.usecase;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.Comp_Assign_Eng;
import com.masai.bean.Complain;
import com.masai.bean.Employee;
import com.masai.exception.ComplainException;
import com.masai.exception.EmployeeException;

public class EmployeeUseCase {
	
	public static void getEmployeeOptions(Employee emp) {
		Scanner sc = new Scanner(System.in);
		
	System.out.println("\nHello Employee "+emp.getUsername()+"\n");
		
		while(true) {
			
			
		System.out.println();
		System.out.println("1. Register a Complaint ");
		System.out.println("2. Know About Your Complain Engineer");
		System.out.println("3. Get Your Complaint History ");
		System.out.println("4. Change Your Password ");
		System.out.println("5. LogOut ");
		int c = sc.nextInt();
		
		if(c==1) {
		    System.out.println("Register a Complaint");
		    System.out.println("=====================");
		    String status="raised";
		    System.out.println("Enter Your description about Complaint");
		    String des = sc.next();
		    System.out.println("Enter The category of Complaint");
		    String category = sc.next();
		     String res=null;
			try {
				res = emp.regAComp(status, des,category, emp);
				  System.out.println(res);
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    
		}
		else if(c==2) {
			System.out.println("Get Your Complaint Details ");
			System.out.println("==========================");
			
			System.out.println("Enter Your Complaint Id ");
			int compid = sc.nextInt();
			
			
			
			Comp_Assign_Eng coe=null;
			try {
				coe = emp.getCompDetails(compid, emp);

				System.out.println("Complaint id : "+coe.getCompid());
				System.out.println("Complaint Status : "+coe.getStatus());
				System.out.println("Complaint Description : "+coe.getDes());
				System.out.println("Complaint Category : "+coe.getCategory());
				System.out.println("Assigned Engineer : "+coe.getEng_username());
				System.out.println();
				
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else if(c==3) {
			System.out.println("Get Your Complaint History ");
			System.out.println("===========================");
			List<Complain> complist=null;
			try {
				complist = emp.getYourCompHistory(emp);
				complist.forEach(com->{
					System.out.println("Complaint Id : "+com.getCompid());
					System.out.println("Complaint Status : "+com.getStatus());
					System.out.println("Complaint Des : "+com.getDes());
					System.out.println("Complaint Category : "+com.getCategory());
					System.out.println("Assigned Engineer : "+com.getEmp_username());
					System.out.println("-----------------------------------------");
					
				});
				
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(c==4) {
			System.out.println("Change Your Password ");
			System.out.println("=====================");
			System.out.println("Enter new Password ");
			String newPass = sc.next();
			String res=null;
			try {
				res = emp.changePass(newPass, emp);
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(res);
		}else if(c==5) {
			System.out.println("Thank You ");
			Main1.homepage();
			break;
		}
		else {
			System.out.println("Invalid Input ");
		}
		
		
	}
		
		
		
		
		
		
	}
	
          
	

	

}
