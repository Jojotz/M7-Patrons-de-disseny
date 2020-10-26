package applications;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class MyExceptions extends InputMismatchException {
	
	public MyExceptions() {}
	
	public static int wrongChoice (int choice) {
		
		while (choice > 4 || choice < 1) {
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("N�mero introdu�t incorrecte! Recorda: 1.- Crea video. / 2.- Crea usuari. / 3.- Veure llistat videos. / 4.- Tanca programa."));
		}		
		return choice;		
	}	
	
	public static boolean checkAddTag (int addMoreTags) {
						
		while (addMoreTags > 1 || addMoreTags < 0) {
						
			addMoreTags = Integer.parseInt(JOptionPane.showInputDialog("N�mero introdu�t incorrecte! Recorda: 0.- No afegir m�s tags. / 1.- Afegir m�s tags."));
		}
		
		return true;
	}
}