package videos;


import java.util.ArrayList;

import java.util.Scanner;

public class Use_video {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner scanner = new Scanner(System.in);	
    ArrayList<Usuari> listaUsuarios = new ArrayList<Usuari>();
    Usuari usuario;
    Usuari usuarioExistente;
    int opcion; 
    
    do {
	    System.out.println("Qué acción quieres realizar? \n 1: Registrar un nuevo usuario \n 2: Acceder a un usuario existente \n 3: Salir");
	    opcion = scanner.nextInt();
	    
	    switch(opcion) {
	    	case 1:
	    		System.out.println("Registrar un nuevo usuario");
	    		usuario = new Usuari();
	    		usuario.setNom();
	    		usuario.setCognom();
	    		usuario.setPasswordRegistro();
	    		usuario.setDataRegistre();
	    		usuario.toString();
	    		listaUsuarios.add(0,usuario);
	    		try {
	    			usuario.validarDatosUsuario();
	    		}catch(Exception e) {
	    			System.out.println("No puedes dejar datos vacíos");
	    		}
	    		for(int i=1; i<listaUsuarios.size(); i++) {
	    			if(listaUsuarios.get(0).equals(listaUsuarios.get(i))) {
	    				System.out.println("Este usuario ya existe");
	    				listaUsuarios.remove(0);
	    			}else {
	    				System.out.println("Perfecto! Usuario registrado: \n" + usuario.toString());	
	    			}
	    		}
	    		System.out.println(listaUsuarios.toString());
	    		break;
	    	case 2:
	    		System.out.println("Acceder a un usuario existente");
	    		
	    		usuarioExistente = new Usuari();
	    		usuarioExistente.setNom();
	    		usuarioExistente.setCognom();
	    		usuarioExistente.setPassword();
	    	
    			if(listaUsuarios.contains(usuarioExistente)){
    				System.out.println("Estás dentro de tu usuario");
    				usuarioExistente.accionesUsuario();
    			}else {
	    			System.out.println("Este usuario no existe");
	    		}
	    		break;
	    	case 3:
	    		System.out.println("Exit");
	    		break;
	    	default:
	    	System.out.println("Error");
	    }
    }while(opcion!= 3) ;    	
	}
}