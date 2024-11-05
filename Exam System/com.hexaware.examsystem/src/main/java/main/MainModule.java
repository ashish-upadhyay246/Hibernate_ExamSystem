package main;
import java.util.Scanner;
import entity.User;
import dao.IOnlineExamSystem;
import dao.OnlineExamSystemImpl;
public class MainModule {

	public static void registeringUser()
	{
		
		Scanner sc=new Scanner(System.in);
		String userid,name,email,password,role;
		System.out.println("Enter userid: ");
		userid=sc.nextLine();
		
		System.out.println("Enter name: ");
		name=sc.nextLine();
		
		System.out.println("Enter email: ");
		email=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		System.out.println("Enter role: ");
		role=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		User u1=new User(userid,name,email,password,role);
		iobj.register(u1);
		
	}
	
	private static void logging() {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.login(uid,password);
		
	}
	
	private static void modifybynormaluser() {
		// TODO Auto-generated method stub
		//modifying email and password
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.modify(uid,password);
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		while(true) {
	System.out.println("----Main Menu---");
	System.out.println("1.Register");
	System.out.println("2.Login");
	System.out.println("3.Modify Email and password");
	System.out.println("4.If Admin, add user");
	System.out.println("5.If Admin, remove user");
	System.out.println("6.If Admin, modify user");
	System.out.println("7.If Admin, add question");
	System.out.println("8.If Admin, modify question");
	System.out.println("9.If Admin, remove question");
	System.out.println("Any number to exit(other than 1-9)");
	int ch=sc.nextInt();
	if(ch==1)
	{
		registeringUser();
	}
	else if(ch==2)
	{
		logging();
	}
	else if(ch==3)
	{
		modifybynormaluser();
	}
	else if(ch==4)
	{
		addUserByAdmin();
	}
	else if(ch==5)
	{
		removeUserByAdmin();
	}
	else if(ch==6)
	{
		modifyUserByAdmin();
	}
	else if(ch==7)
	{
		addQuesByAdmin();
	}
	else if(ch==8)
	{
		modifyQuesByAdmin();
	}
	else if(ch==9)
	{
		removeQuesByAdmin();
	}
	else
	{
		System.exit(0);
	}
		}
	}

	private static void removeQuesByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.removeQuesByAdmin(uid,password);
	}

	private static void modifyQuesByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.modifyQuesByAdmin(uid,password);
	}

	private static void addQuesByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.addQuesByAdmin(uid,password);
		
	}

	private static void modifyUserByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.modifyByAdmin(uid,password);
		
	}

	private static void removeUserByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.removeUserByAdmin(uid,password);
	}

	private static void addUserByAdmin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String uid,password;
		System.out.println("First you have to login.");
		
		System.out.println("Enter user id: ");
		uid=sc.nextLine();
		
		System.out.println("Enter password: ");
		password=sc.nextLine();
		
		IOnlineExamSystem iobj= new OnlineExamSystemImpl();
		iobj.addUserByAdmin(uid,password);
		
	}

	
	

}
