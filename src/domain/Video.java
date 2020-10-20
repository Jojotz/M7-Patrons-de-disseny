package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import applications.MyExceptions;
import persistence.UserRepository;

public class Video {

	private String tittle;									
	private String url;
	private static List<String> tags = new ArrayList<String>();
	static Scanner entradaV = new Scanner(System.in);
	static Scanner entradaV2 = new Scanner(System.in);
	
	public Video (String tittle, String url, List<String> tags) throws Exception {
		
		if (tittle.equals(""))
			throw new Exception();
		if (url.equals(""))
			throw new Exception();
							
		this.tittle = tittle;
		this.url = url;
		this.tags= tags;		
	}	
	
	public static List<String> addTag () {
		
		String tag = "";
		System.out.println("Introdueix els tags del teu video: ");
		int addMoreTags = 1;
		
		while (addMoreTags == 1) {
			
			do {
			
				tag = entradaV.nextLine();
				tags.add(tag);
				System.out.println("Vols afegir més tags? 0.- No / 1.- Sí. ");
				addMoreTags = entradaV2.nextInt();
						
			} while (MyExceptions.checkAddTag(addMoreTags) == true && addMoreTags == 1); 
		}
		return tags;
	}
}
