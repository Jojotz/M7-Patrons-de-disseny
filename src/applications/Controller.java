package applications;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import domain.User;
import domain.Video;
import persistence.UserRepository;

public class Controller {

	public UserRepository repository;
	
	public Controller(UserRepository repository){ 
		
		this.repository = repository;		
	}	
	
	public void createUser(String name, String surname, String password, LocalDate registerDate) throws Exception {		
		
		User user = new User (name, surname, PasswordFactory.createPassword(), registerDate);
		repository.addUser(user);		
	}
	
	public void createVideo (String name, String surname, String tittle, String url) throws Exception {
		
		Video video = new Video (tittle, url, Video.addTag());
		
		UserRepository.findUser(name, surname).vids.add(video);					
	}
	
	public String seeAllUsers() {
		
		List<User> users = new ArrayList<>();
		
		users = repository.getAllUsers ();
		
		String usersString = "";
		
		for (int i=0; i<users.size(); i++) {
			
			usersString += users.get(i).name + " ";
			usersString += users.get(i).surname + ", ";
			usersString += "contrasenya: " + users.get(i).password + ", ";
			usersString += "data registre: " + users.get(i).registerDate + "." + "\n";
			//usersString += users.get(i).vids +"." + " \n";
		}	
				
		return usersString;	
	}
}
