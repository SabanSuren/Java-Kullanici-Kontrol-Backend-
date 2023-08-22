package Main.core.concretes;

import Main.core.abstracts.RegisterService;
import Main.entities.concrete.Users;
import Main.google.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements RegisterService{

	@Override
	public boolean register(Users users) {
		GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
		googleRegisterManager.register(users);
		return true;
	}


}
