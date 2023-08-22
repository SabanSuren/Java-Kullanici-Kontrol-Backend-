package Main.core.concretes;

import Main.core.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void sendVerificationEmail() {
		System.out.println("Dogrulama e-postasi gonderildi");
		
	}

	@Override
	public boolean checkEmail() {
		
		return true;
	}
	

}
