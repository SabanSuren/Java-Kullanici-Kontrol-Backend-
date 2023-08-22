package Main.business.abstracts;

import Main.entities.concrete.Users;

public interface UserService {
	void register(Users users);
	void registerWithGoogle(Users users);
	
	void delete(Users users);
	void login(Users users, String email,String password);

}
