package dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import entity.User;
import entity.Question;

public class OnlineExamSystemImpl implements IOnlineExamSystem{
    @Override
    public void register(User obj) {
    	SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
        Session sess = fac.openSession();

        Transaction tax = sess.beginTransaction();        
        sess.save(obj);
        tax.commit();
        sess.close();
        fac.close();
        System.out.println("User  registered: " + obj);
    }
    
    @Override
    public void  login(String uid, String password)
    {
    	SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
        User u = ses.find(User.class,uid);
        ses.close();
        if(u==null)
        	System.out.println("Invalid User");
        
    	
		String p=u.getPassword();
		if( p.equals(password) ) 
		{
			ses.close();
			System.out.println("Valid User,Logged In");
		}		
    }

	@Override
	public void modify(String uid, String password) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
       
        if(u==null)
        	System.out.println("Invalid User");
		String p=u.getPassword();
		if( p.equals(password) ) 
		{
			System.out.println("Valid User.");
			String ne,np;
			System.out.println("Enter new email");
			ne=sc.nextLine();
			System.out.println("Enter new password");
			np=sc.nextLine();
			u.setEmail(ne);
			u.setPassword(np);
			ses.save(u);
			tax.commit();
		    ses.close();
		    fac.close();
		    System.out.println("The modified Details: " + u);
		}		
	}

	@Override
	public void addUserByAdmin(String uid, String password) {
		
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
        if(u==null)
        	System.out.println("Invalid User");
        
		String p=u.getPassword();
		if( p.equals(password) ) 
		{
			
			System.out.println("Valid User.");
			String checkrole=u.getRole();
			if(checkrole.equals("admin"))
			{
				System.out.println("You can proceed to add user");
				Scanner sc=new Scanner(System.in);
				String userid,name,email,pass,role;
				System.out.println("Enter userid: ");
				userid=sc.nextLine();
				
				System.out.println("Enter name: ");
				name=sc.nextLine();
				
				System.out.println("Enter email: ");
				email=sc.nextLine();
				
				System.out.println("Enter password: ");
				pass=sc.nextLine();
				
				System.out.println("Enter role: ");
				role=sc.nextLine();
				
				IOnlineExamSystem iobj= new OnlineExamSystemImpl();
				User u1=new User(userid,name,email,pass,role);
				iobj.register(u1);
			}
			else
			{
				System.out.println("You are not admin.");			
			}		 	
		}	
	}

	@Override
	public void removeUserByAdmin(String uid, String password) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
        if(u==null)
        	System.out.println("Invalid User");
		String p=u.getPassword();
		if( p.equals(password) ) 
		{
			
			System.out.println("Valid User.");
			String checkrole=u.getRole();
			if(checkrole.equals("admin"))
			{
				System.out.println("You can proceed to remove user");
				String userid;
				System.out.println("Enter userid of the user: ");
				userid=sc.nextLine();
				User to_remove=ses.find(User.class,userid);
				if(to_remove==null)
		        	System.out.println("User not found");
				else
				{
				 ses.delete(to_remove);
			      tax.commit();	
			      ses.close();
				   fac.close();
				   System.out.println("User removed");
			    }
			}
			else
			{
				System.out.println("You can not proceed");
			}
		}
		else
		{
			System.out.println("Incorrect Password");
		}
	}

	@Override
	public void modifyByAdmin(String uid, String password) {
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
       
        if(u==null)
        	System.out.println("Invalid User");    	
		String p=u.getPassword();
		if( p.equals(password) ) 
		{
			
			System.out.println("Valid User.");
			String checkrole=u.getRole();
			if(checkrole.equals("admin"))
			{
				System.out.println("You can proceed to modify user");
				Scanner sc=new Scanner(System.in);
				
				
				String userid;
				System.out.println("Enter userid to modify: ");
				userid=sc.nextLine();
				
				User to_modify=ses.find(User.class,userid);
				if(to_modify==null)
		        	System.out.println("Invalid User");
				else {
					String name,email,pass,role;
					System.out.println("Enter name: ");
					name=sc.nextLine();
					to_modify.setName(name);
					System.out.println("Enter email: ");
					email=sc.nextLine();
					to_modify.setEmail(email);
					System.out.println("Enter password: ");
					pass=sc.nextLine();
					to_modify.setPassword(pass);
					System.out.println("Enter role: ");
					role=sc.nextLine();
					to_modify.setRole(role);
					ses.save(to_modify);
					tax.commit();

			        ses.close();
			        fac.close();
			        System.out.println("The modified Details: " + to_modify);
				}	
			}
			else
			{
				System.out.println("You are not admin.");							
			}					
		}
		else
		{
			System.out.println("Incorrect Password");
		}
	}

	@Override
	public void addQuesByAdmin(String uid, String password) {
		// TODO Auto-generated method stub
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
        if(u==null)
        	System.out.println("Invalid User");

		String p=u.getPassword();
		if( p.equals(password) && (u.getRole()).equals("admin")) 
		{
			Scanner sc =new Scanner(System.in);
			
			System.out.println("You can proceed to add quesiton.");
			int qid;
			String qtext,opa,opb,opc,opd,ans;
			System.out.println("Enter the question id:");
			qid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the question:");
			qtext=sc.nextLine();
			System.out.println("Enter option a:");
			opa=sc.nextLine();
			System.out.println("Enter option b:");
			opb=sc.nextLine();
			System.out.println("Enter option c:");
			opc=sc.nextLine();
			System.out.println("Enter option d:");
			opd=sc.nextLine();
			System.out.println("Enter correct answer :");
			ans=sc.nextLine();
			Question qobj = new Question(qid,qtext,opa,opb,opc,opd,ans);
			ses.save(qobj);
			tax.commit();
			ses.close();		
			System.out.println("Question added.");
		}
		else
		{
			System.out.println("You can not proceed.");
		}
	}

	@Override
	public void modifyQuesByAdmin(String uid, String password) {
		// TODO Auto-generated method stub
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);
        
        if(u==null)
        	System.out.println("Invalid User");
		String p=u.getPassword();
		if( p.equals(password) && (u.getRole()).equals("admin")) 
		{
			Scanner sc =new Scanner(System.in);
			
			System.out.println("You can proceed to modify quesiton.");
			int qid;
			
			System.out.println("Enter the question id:");
			qid=sc.nextInt();
			sc.nextLine();
			
			Question qobj =ses.find(Question.class, qid);
			if(qobj!=null)
					{
				    String qtext,opa,opb,opc,opd,ans;
					System.out.println("Enter the question:");
					qtext=sc.nextLine();
					System.out.println("Enter option a:");
					opa=sc.nextLine();
					System.out.println("Enter option b:");
					opb=sc.nextLine();
					System.out.println("Enter option c:");
					opc=sc.nextLine();
					System.out.println("Enter option d:");
					opd=sc.nextLine();
					System.out.println("Enter correct answer :");
					ans=sc.nextLine();
					qobj.setQuestionText(qtext);
					qobj.setOptionA(opa);
					qobj.setOptionB(opb);
					qobj.setOptionC(opc);
					qobj.setOptionD(opd);
					qobj.setCorrectAnswer(ans);
					ses.save(qobj);
					tax.commit();
					ses.close();
					System.out.println("Question modified.");
					}
			else
			{
				System.out.println("Invalid questionid.");
			}
		}
		else
		{
			System.out.println("You can not proceed.");
		}
	}

	@Override
	public void removeQuesByAdmin(String uid, String password) {
		// TODO Auto-generated method stub
		SessionFactory fac = new Configuration()
                .configure("hiber.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    	Session ses = fac.openSession();
    	Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class,uid);

        if(u==null)
        	System.out.println("Invalid User");
		String p=u.getPassword();
		if( p.equals(password) && (u.getRole()).equals("admin")) 
		{
			Scanner sc =new Scanner(System.in);
			
			System.out.println("You can proceed to remove quesiton.");
			int qid;
			
			System.out.println("Enter the question id:");
			qid=sc.nextInt();
			sc.nextLine();
			
			Question qobj =ses.find(Question.class, qid);
			if(qobj!=null)
			{
				ses.delete(qobj);
				tax.commit();
				ses.close();	
				System.out.println("Question removed.");
			}
			else
			{
				System.out.println("Invalid questionid.");
			}
		}
		else
		{
			System.out.println("You can not proceed.");
		}
	}	
}
