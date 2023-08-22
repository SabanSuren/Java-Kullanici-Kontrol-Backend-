package Main.google;

import Main.entities.concrete.Users;

public class GoogleRegisterManager {
	
	public void register(Users users) {
		System.out.println(users.getFirstName()+ " " + users.getEmail());
	}

}
