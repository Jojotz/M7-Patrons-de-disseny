package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

	public String name;
	public String surname;
	public String password;
	public LocalDate registerDate;
	public List<Video> vids = new ArrayList<Video>();
	
	public User (String name, String surname, String password, LocalDate registerDate, List<Video> vids) throws Exception {
		
		if (name.equals(""))
			throw new Exception();
		if (surname.equals(""))
			throw new Exception();
		if (password.equals(""))
			throw new Exception();
		if (registerDate.equals(""))
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}		
}
