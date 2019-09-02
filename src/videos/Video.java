package videos;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Video {
	private String url;
	private String titol;
	private ArrayList<String> tags = new ArrayList<String>();
	
	Scanner scanner = new Scanner(System.in);
	
	public Video() {
		
	}
	
	public void setUrl() {
		System.out.println("Introduce la URL de tu video");
		url = scanner.nextLine();
	}
	public String getUrl() {
		return url;
	}
	public void setTitol() {
		System.out.println("Introduce el título de tu video");
		titol = scanner.nextLine();
	}
	public String getTitol() {
		return titol;
	}
	public void setTags() {
		int opcion;
		String tag;
		do {
		System.out.println("1.Introducir tags \n2.Exit tags");
			opcion = scanner.nextInt();
			switch(opcion){
				case 1:
					System.out.println("Introduce un tag");
					tag = scanner.next();
					tags.add(tag);
					break;
				case 2:
					System.out.println("Exit tags");
					break;
				default:
					System.out.println("Error");
			}		
		}while(opcion != 2);
			
	}
	public ArrayList<String> getTags(){
		for (int i=0; i<tags.size(); i++) {
			tags.get(i);
			}
		return tags;
	}
	public String dimeVideo() {
		String datos = "TÍTULO: " +  titol + "\nURL: " + url + "\nTAGS: " + tags ; 
		return datos;
	}
	public void validarDatosVideo() throws Exception{
		if(titol.equals("") || url.equals("") || tags.size()==0) {
			throw new Exception();
		}
	}
	
	
	
	
}



