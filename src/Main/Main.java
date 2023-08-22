package Main;

import Main.business.abstracts.UserService;
import Main.business.concretes.UserManager;
import Main.core.concretes.EmailManager;
import Main.core.concretes.GoogleRegisterManagerAdapter;
import Main.dataAccsess.concretes.DatabaseUserDao;
import Main.entities.concrete.Users;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new DatabaseUserDao() , new EmailManager(), new GoogleRegisterManagerAdapter());
		
		Users users2 =new  Users(1,"S","S","sabansuren9gmail.com","1234578");
		userService.register(users2);
		System.out.println();
		userService.registerWithGoogle(users2);
		System.out.println();
		userService.login(users2, "sabansuren9gmail.com", "1234578");
	

	}

}
