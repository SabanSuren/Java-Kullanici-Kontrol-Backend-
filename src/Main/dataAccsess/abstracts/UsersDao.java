package Main.dataAccsess.abstracts;


import java.util.List;

import Main.entities.concrete.Users;

public interface UsersDao {
	void add(Users users );
	void update(Users users );
	void delete(Users users );
	Users getEmail(String email);
	List<Users> getAll();
}
