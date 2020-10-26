package view;
//16/10/2020  Joan Coll
//M7 Patrons de disseny

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import applications.MyExceptions;
import domain.User;
import domain.Video;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner entradaM = new Scanner(System.in);
		String name = "";
		String surname = "";
		String password = "";
		LocalDate date = java.time.LocalDate.now();
		
		String tittle = "";									
		String url = "";
		
		System.out.println("Crea el teu primer usuari: ");
		System.out.println("Introdueix el nom: ");
		name = entradaM.nextLine();
		System.out.println("Introdueix el cognom: ");
		surname = entradaM.nextLine();
				
		User.createUser(name, surname, password, date);
		entradaM.close();
				
		String allUsers = User.seeAllUsers1st();
		
		System.out.println(allUsers);
		
		int choice = 0;
		Integer i = null; 
		
		do {
			choice = 0;			
			
			try {
				
				choice = Integer.parseInt(JOptionPane.showInputDialog("Tria què vols fer: 1.- Crea video. / 2.- Crea usuari. / 3.- Veure llistat videos. / 4.- Tanca programa."));
				i = choice;
				choice = MyExceptions.wrongChoice(choice);
				
			} catch (NumberFormatException e) {
			        
			  System.out.println("Error! Recorda: 1.- Crea video. / 2.- Crea usuari. / 3.- Veure llistat videos. / 4.- Tanca programa.");
			}
			
			switch  (choice) {			
						
				case 1:
				
					name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
					surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
					User foundUser = User.findUser(name, surname);
					
					while (foundUser == null) {
						
						System.out.println("No s'ha trobat l'usuari! torna-ho a provar.");
						name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
						surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
						foundUser = User.findUser(name, surname);
					}
					
					tittle = JOptionPane.showInputDialog("Introdueix el titol del video: ");
					url = JOptionPane.showInputDialog("Introdueix la URL del video: ");
					
					ArrayList<String> tagsVid = Video.createTag();
					Video videoUser = new Video (tittle, url, tagsVid);
					foundUser.vids.add(videoUser);
					System.out.println("S'ha afegit el video correctament a l'usuari: " + foundUser.getName() + " " + foundUser.getSurname() + "." + "\n");					
					i = null;
					
				break; 
				
				case 2:
					
					name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
					surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
					User duplicateUser = User.findUser(name, surname);
					
					while (duplicateUser !=null) {
						
						System.out.println("L'usuari ja existeix, torna-ho a provar.");
						name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
						surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
						duplicateUser = User.findUser(name, surname);
					}
					
					String passwordB = "";
					LocalDate dateB = java.time.LocalDate.now();
					User.createUser(name, surname, passwordB, dateB);
					i = null;
									
				break; 	
				
				case 3:
					
					name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
					surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
					User showUser = User.findUser(name, surname);
					
					while (showUser == null) {
						
						System.out.println("No s'ha trobat l'usuari! torna-ho a provar.");
						name = JOptionPane.showInputDialog("Introdueix el nom de l'usuari: ");
						surname = JOptionPane.showInputDialog("Introdueix el cognom de l'usuari: ");
						showUser = User.findUser(name, surname);
					}
					
					System.out.println("L'usuari " + showUser.getName() + " " + showUser.getSurname() + ", conté els videos:" + "\n");
					System.out.println(showUser.getVids(showUser) + "\n");
					i = null;
					
				break; 
				
				case 4:
					
				break;
				
				default: 						
			}	
			
		} while (i == null && choice != 4); 
	}
}