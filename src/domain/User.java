package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import applications.PasswordFactory;

public class User {

	protected String name;
	protected String surname;
	protected String password;
	protected LocalDate registerDate;
	
	protected static ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Video> vids = new ArrayList<Video>();
	
	public User (String name, String surname, String password, LocalDate registerDate, ArrayList<Video> vids) throws Exception {
		
		if (name.equals(""))
			throw new Exception();
		if (surname.equals(""))
			throw new Exception();
		if (password.equals(""))
			throw new Exception();
									
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.registerDate = registerDate;
		this.vids= vids;		
	}	
	
	public User (String name, String surname, String password, LocalDate registerDate) throws Exception {
		
		if (name.equals(""))
			throw new Exception();
		if (surname.equals(""))
			throw new Exception();
		if (password.equals(""))
			throw new Exception();
							
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.registerDate = registerDate;
	}
	
	public static void createUser(String name, String surname, String password, LocalDate registerDate) throws Exception {		
		
		User user = new User (name, surname, PasswordFactory.createPassword(), registerDate);		
		users.add(user);
		System.out.println("S'ha creat l'usuari: " + user.getName() + " " + user.getSurname() + ", contrasenya: " + user.getPassword() + ", data registre: " + user.getRegisterDate() + "." + "\n");
	}
	
	public List<User> getAllUsers() {
		
		return new ArrayList<User>(users);
	}
	
	public static User findUser (String name, String surname) {
		
		for (User u : users) {
			
			if (u.getName().equals(name) && u.getSurname().equals(surname)) {
				
				return u;
			}				
		}		
		return null;
	}
	
	public static String seeAllUsers1st() {
		
		String usersString = "";
		
		for (int i=0; i<users.size(); i++) {
			
			usersString += users.get(i).getName() + " ";
			usersString += users.get(i).getSurname() + ", ";
			usersString += "contrasenya: " + users.get(i).getPassword() + ", ";
			usersString += "data registre: " + users.get(i).getRegisterDate() + "." + "\n";
		}					
		return usersString;	
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public String getVids (User showUser) {
		
		String allVids = "";
		
		for (int i=0; i<showUser.vids.size(); i++) {
			
			allVids += "Títol: " + showUser.vids.get(i).getTittle() + ", ";
			allVids += "URL: "+ showUser.vids.get(i).getUrl() + ", ";
			allVids += "amb tags: " + showUser.vids.get(i).getTags(showUser.vids.get(i)) + ".";
		}		
		return allVids;		
	}		
}