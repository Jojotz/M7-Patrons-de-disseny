package applications;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptions extends InputMismatchException {
	
	static Scanner entradaE = new Scanner(System.in);
	
	public MyExceptions() {}
	
	/*public wrongChoice (int choice) {
		super (choice);
		
		
	}	*/
	
	public static boolean checkAddTag (int addMoreTags) {
						
		while (addMoreTags > 1 || addMoreTags < 0) {
			System.out.println("N�mero introdu�t incorrecte! Recorda: 0.- No afegir m�s tags. / 1.- Afegir m�s tags.");
			addMoreTags = entradaE.nextInt();	
			//entrada3.nextLine();
		}
		
		return true;
	}
}
