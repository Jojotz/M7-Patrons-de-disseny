package view;
//16/10/2020  Joan Coll
//M7 Patrons de disseny

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import applications.Controller;
import domain.Video;
import persistence.UserRepository;

public class Main {
	
	private static UserRepository userList = new UserRepository();
	private static Controller controller = new Controller(userList);
	
	static Scanner entradaM = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		//Scanner entradaM = new Scanner(System.in);
		String name = "";
		String surname = "";
		String password = "";
		LocalDate date = java.time.LocalDate.now();
		String tittle;									
		String url;
		
		System.out.println("Crea el teu primer usuari: ");
		System.out.println("Introdueix el nom: ");
		name = entradaM.nextLine();
		System.out.println("Introdueix el cognom: ");
		surname = entradaM.nextLine();
				
		controller.createUser(name, surname, password, date);
		System.out.println("S'ha creat el primer usuari: ");
		
		String allUsers = controller.seeAllUsers();
		
		System.out.println(allUsers + " \n");
		//entradaM.close();
		
		int choice = 0;
		//Scanner entradaM = new Scanner(System.in);
		
		while (choice != 4) {
						
			System.out.println("Tria què vols fer: 1.- Crea video. / 2.- Crea usuari. / 3.- Veure llistat videos. / 4.- Tanca programa. ");
			
			//try {
			
			choice = entradaM.nextInt();
			
			/*} catch (InputMismatchException e) {
				
				System.err.println("No has introuduït un número vàlid! Torna-ho a provar siusplau");
				choice = entradaM2.nextInt();
			}*/
			
			if (choice == 1) {
				
				System.out.println("Introdueix el nom de l'usuari: ");
				name = entradaM.nextLine();
				System.out.println("Introdueix el cognom de l'usuari: ");
				surname = entradaM.nextLine();
				System.out.println("Introdueix el titol del video: ");
				tittle = entradaM.nextLine();
				System.out.println("Introdueix la URL del video: ");
				url = entradaM.nextLine();
				
				controller.createVideo(name, surname, tittle, url);
				
				
			}
		}
	}
}
