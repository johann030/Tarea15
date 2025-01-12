package dao;

import java.util.List;

import modelo.Alumno;
import modelo.Grupo;

public interface AlumnoDao {

	int insertarAlumno(Alumno al);

	int insertarGrupo(Grupo gp);

	List<Alumno> mostrarAlumnos();

	void guardarTxt();

	void leerTxt();

	int cambiarNombre(int id);

	void borrarPK(int id);

	void borrarApellido(Alumno al);

	void borrarGrupo(Grupo gp);

	void guardarXml(Alumno al);

	void leerXml(Alumno al);
}