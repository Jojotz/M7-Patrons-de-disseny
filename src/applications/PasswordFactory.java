package applications;

import java.util.Scanner;
import java.util.regex.*;

public class PasswordFactory {

	public static String createPassword () {
		
		Scanner entradaP = new Scanner(System.in);
		String password = "";
		boolean check = false;
		
		System.out.println("Introdueix la teva contrasenya: de 8 a 20 caràcters, amb: mínim 1 digit, 1 Majúscula, 1 minúscula, i sense espais en blanc.");
				
		do {
			
			password = entradaP.nextLine();
			check = isValidPassword(password);
			
			if (!check) {
				System.out.println("Contrasenya incorrecta! recorda: de 8 a 20 caràcters, amb: mínim 1 digit, 1 Majúscula, 1 minúscula, i sense espais en blanc.");
			}			
		} while (!check);
		
		System.out.println("Contrasenya correcta!");
		entradaP.close();
		return password;
	}
	
	public static boolean isValidPassword(String password) { 
  
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$"; 
          
        Pattern p = Pattern.compile(regex); 
  
        if (password == null) { 
            return false; 
        } 
  
        Matcher m = p.matcher(password); 

        return m.matches(); 
    } 
}