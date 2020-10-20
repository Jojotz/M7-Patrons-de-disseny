package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserRepository {
	
	private static List<User> users = new ArrayList<>();
	
	public UserRepository(){}
	
	public List<User> getAllUsers() {
		
		return new ArrayList<>(users);
	}
		
	public void addUser(User user) throws Exception {
		if(user==null) throw new Exception();
		users.add(user);
	}
	
	public static User findUser (String name, String surname) {
		
		User foundUser = null;
		
		for (User u : users) {
			
			if ((name == ((User) users).getName()) && (surname == ((User) users).getSurname())) {
				
				foundUser = u;
			}				
		}		
		return foundUser;
	}
}
