package main;

import dao.AlumnoDao;
import modelo.Alumno;
import dao.AlumnoBD;
import vista.IVista;
import vista.VistaConsola;

public class Controlador {

	public static void main(String[] args) throws Exception {
//		AlumnoDao modelo = new AlumnoDaoImpl();
//		IVista vista = new VistaConsola();
//		new Controlador().ejecutar(modelo, vista);
		IVista vista = new IVista();
		vista.init();

	}

	public void ejecutar(AlumnoDao modelo, IVista vista) {
		// TODO
	}
}