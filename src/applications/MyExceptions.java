package applications;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class MyExceptions extends InputMismatchException {
	
	public MyExceptions() {}
	
	public static int wrongChoice (int choice) {
		
		while (choice > 4 || choice < 1) {
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("Número introduït incorrecte! Recorda: 1.- Crea video. / 2.- Crea usuari. / 3.- Veure llistat videos. / 4.- Tanca programa."));
		}		
		return choice;		
	}	
	
	public static boolean checkAddTag (int addMoreTags) {
						
		while (addMoreTags > 1 || addMoreTags < 0) {
						
			addMoreTags = Integer.parseInt(JOptionPane.showInputDialog("Número introduït incorrecte! Recorda: 0.- No afegir més tags. / 1.- Afegir més tags."));
		}
		
		return true;
	}
}