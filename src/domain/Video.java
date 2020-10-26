package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import applications.MyExceptions;

public class Video {

	protected String tittle;									
	protected String url;
	private ArrayList<String> tags = new ArrayList<String>();
	
	public Video (String tittle, String url, ArrayList<String> tags) throws Exception {
		
		if (tittle.equals(""))
			throw new Exception();
		if (url.equals(""))
			throw new Exception();
							
		this.tittle = tittle;
		this.url = url;
		this.tags= tags;		
	}
	
	public String getTittle() {
		return tittle;
	}

	public String getUrl() {
		return url;
	}

	public static ArrayList<String> createTag () throws Exception  {
		
		String tag = "";
		int addMoreTags = 1;
		ArrayList<String> tagsToAdd = new ArrayList<>();
				
		while (addMoreTags == 1) {
			
			do {			
				tag = JOptionPane.showInputDialog("Introdueix un tag del teu video: ");
				if (tag.equals(""))
					throw new Exception();
				tagsToAdd.add(tag);
				try	{
					addMoreTags = Integer.parseInt(JOptionPane.showInputDialog("Vols afegir més tags? 0.- No / 1.- Sí. "));
				}
				catch (InputMismatchException e) {
					addMoreTags = Integer.parseInt(JOptionPane.showInputDialog("Error! Torna-ho a provar siusplau. Vols afegir més tags? 0.- No / 1.- Sí. "));
					//continue;
				}	
					
			} while (MyExceptions.checkAddTag(addMoreTags) == true && addMoreTags == 1);
		}			
		return tagsToAdd;
	}	
	
	public String getTags (Video vid) {
		
		String allTags = "";
		
		for (int i=0; i<tags.size(); i++) {
			
			allTags += tags.get(i) + " / ";
		}
		
		return allTags;		
	}
}