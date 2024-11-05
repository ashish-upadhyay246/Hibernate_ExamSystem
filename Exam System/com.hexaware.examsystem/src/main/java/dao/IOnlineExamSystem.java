package dao;
import entity.User;
public interface IOnlineExamSystem {
	void register(User obj);
    void  login(String email, String password);
    void modify(String uid, String password);
    void addUserByAdmin(String uid, String password);
	void removeUserByAdmin(String uid, String password);
	void modifyByAdmin(String uid, String password);
	void addQuesByAdmin(String uid, String password);
	void modifyQuesByAdmin(String uid, String password);
	void removeQuesByAdmin(String uid, String password);
	
}
