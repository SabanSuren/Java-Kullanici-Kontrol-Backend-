package Main.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Main.business.abstracts.UserService;
import Main.core.abstracts.EmailService;
import Main.core.abstracts.RegisterService;
import Main.dataAccsess.abstracts.UsersDao;
import Main.entities.concrete.Users;

public class UserManager implements UserService{
	private UsersDao usersDao;
	private EmailService emailService;
	private RegisterService registerService;
	
	public UserManager(UsersDao usersDao, EmailService emailService,RegisterService registerService) {
		this.usersDao=usersDao;
		this.emailService=emailService;
		this.registerService = registerService;
		
	}
	

	@Override
	public void register(Users users) {
		if (users.getPassword().length()<6) {
			System.out.println("Sifre en az 6 karakterden olusmalıdır");
			return;
		}
		final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(users.getEmail());
		
		if(!matcher.matches()) {
			System.out.println("Desteklenmeyen EPosta Formati");
			
		}
		else {
			System.out.println("Eposta");
		}
		for (Users users1 : usersDao.getAll()) {
			if (users1.getEmail() == users1.getEmail()) {
				System.out.println("Sisteme kayıtlı e-posta");
				return;
			}
		}
		if (users.getFirstName().length() < 2 || users.getLastName().length() < 2) {
			System.out.println("Ad ve Soyad en az iki karakterden oluşmalıdır.");
			return;
		}else {
			System.out.println("Kullanıcı bilgileri hatalı");
		}
		this.usersDao.add(users);
		this.emailService.sendVerificationEmail();
		if (this.emailService.checkEmail()) {
			System.out.println("Dogrulama basarili:");
		} else {
			System.out.println("Dogrulama basarisiz:");
		}
		
	}

	@Override
	public void registerWithGoogle(Users users) {
		if (registerService.register(users)) {
			System.out.println("Google ile kayit basarili");
		} else {
			System.out.println("Google ile kayit basarisiz");
		}
		
	}

	@Override
	public void delete(Users users) {
		System.out.println("Kullanıcı silindi: " + users.getFirstName() + " " + users.getLastName());
		
	}

	@Override  
	public void login(Users users, String email, String password) {
		if (users.getEmail().equals(email) && users.getPassword().equals(password)) {
			System.out.println("Giris Basarılı: " + users.getFirstName());
		} else {
			System.out.println("Sifre veya Kullanici Adi yanlis");
		}

	
		
	}

}
