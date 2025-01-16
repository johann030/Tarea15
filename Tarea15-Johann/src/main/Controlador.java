package main;

import dao.AlumnoDao;
import dao.AlumnoBD;
import vista.IVista;
import vista.VistaConsola;

public class Controlador {

	public static void main(String[] args) throws Exception {
//		AlumnoDao modelo = new AlumnoBD();
		IVista vista = new VistaConsola();
//		new Controlador().ejecutar(modelo, vista);

	}

	public void ejecutar(AlumnoDao modelo, IVista vista) {
		// TODO
	}
}