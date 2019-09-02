package videos;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Usuari {
	
	//Atributos
	private String nom;
	private String cognom;
	private String password;
	private Date dataRegistre;
	
	private ArrayList<Video> listadoVideos = new ArrayList<Video>();
	private Video nuevoVideo;
	Scanner scanner = new Scanner(System.in);
	
	//Constructor
	public Usuari() {
	}
	
	//Métodos
	public void setNom() {
		System.out.println("Introduce tu nombre");
		nom = scanner.nextLine();
	}
	public String getNom() {
		return nom;
	}
	public void setCognom() {
		System.out.println("Introduce tu apellido");
		cognom = scanner.nextLine();
	}
	public String getCognom() {
		return cognom;
	}
	public void setPasswordRegistro() {
		String password2;
		do {
			System.out.println("Introduce tu password");
			password = scanner.nextLine();
			System.out.println("Vuelve a introducir tu password");
			password2 = scanner.nextLine();	
		}while(!password.equals(password2));	
		
	}
	public void setPassword() {
		System.out.println("Introduce tu password");
		password = scanner.nextLine();
		}
	public String getPassword() {
		return password;
	}
	public void setDataRegistre() {
		GregorianCalendar calendario = new GregorianCalendar();
		dataRegistre = calendario.getTime();
	}
	public Date getDataRegistre() {
		return dataRegistre;
	}
	public String toString() {
		return "NOMBRE: " + nom + " " + cognom;
	}	
	//Métodos aparte
	
	public void accionesUsuario() {
		int opcion;
		do {
			System.out.println(nom + " qué quieres hacer? \n 1. Crear un nuevo vídeo \n 2. Ver un listado de tus vídeos \n 3. Exit usuario");
			opcion = scanner.nextInt();
			
			switch(opcion) {
				case 1:
					nuevoVideo = new Video();
					nuevoVideo.setTitol();
					nuevoVideo.setUrl();
					nuevoVideo.setTags();
					System.out.println(nuevoVideo.dimeVideo());
					listadoVideos.add(0,nuevoVideo);
					try {
					nuevoVideo.validarDatosVideo();
					}catch (Exception e) {
						System.out.println("No puedes dejar ningún dato vacío");
					}
					break;
				case 2:
					System.out.println("Lista de vídeos de " + nom + ":");
					for(int i=0; i<listadoVideos.size(); i++) {
						System.out.println("VIDEO " + (i+1) + "\n" + listadoVideos.get(i).dimeVideo());
					}
					break;
				case 3:
					System.out.println("Exit usuario");
					break;
				default:
					System.out.println("Error");
				
			}
		}while(opcion!=3);
	}
	public void validarDatosUsuario() throws Exception{
		if(nom.equals("") || cognom.equals("") || password.equals("")) {
			throw new Exception();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognom == null) ? 0 : cognom.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuari other = (Usuari) obj;
		if (cognom == null) {
			if (other.cognom != null)
				return false;
		} else if (!cognom.equals(other.cognom))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}