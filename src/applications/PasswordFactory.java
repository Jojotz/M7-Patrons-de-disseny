package applications;

import java.util.regex.*;
import javax.swing.JOptionPane;

public class PasswordFactory {

	public static String createPassword () {
		
		String password = "";
		boolean check = false;
				
		do {
			
			password = JOptionPane.showInputDialog("Introdueix la teva contrasenya: de 8 a 20 caràcters, amb: mínim 1 digit, 1 Majúscula, 1 minúscula, i sense espais en blanc.");
			check = isValidPassword(password);
			
			if (!check) {
				System.out.println("Contrasenya incorrecta! recorda: de 8 a 20 caràcters, amb: mínim 1 digit, 1 Majúscula, 1 minúscula, i sense espais en blanc.");
			}			
		} while (!check);
		
		System.out.println("Contrasenya correcta!");
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