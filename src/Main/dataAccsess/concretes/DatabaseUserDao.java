package Main.dataAccsess.concretes;

import java.util.ArrayList;
import java.util.List;

import Main.dataAccsess.abstracts.UsersDao;
import Main.entities.concrete.Users;

public class DatabaseUserDao implements UsersDao {
	
	List<Users> users = new ArrayList<Users>();

	@Override
	public void add(Users users) {
		System.out.println("Kullanıcı Kaydedildi: " + users.getFirstName() + " " + users.getLastName() + " " + users.getEmail());
		/* users.add(users); */
		
	}

	@Override
	public void update(Users users) {
		System.out.println("Kullanıcı Güncellendi: " + users.getFirstName() + " " + users.getLastName() + " " + users.getEmail());
		
	}

	@Override
	public void delete(Users users) {
		System.out.println("User deleted: " + users.getFirstName() + " " + users.getLastName() + " " + users.getEmail());
		/* users.remove(users); */
		
	}

	@Override
	public Users getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
