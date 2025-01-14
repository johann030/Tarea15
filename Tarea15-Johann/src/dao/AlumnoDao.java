package dao;

import java.util.List;

import modelo.Alumno;
import modelo.Grupo;

public interface AlumnoDao {

	int insertarAlumno(Alumno al) throws Exception;

	int insertarGrupo(Grupo gp) throws Exception;

	List<Alumno> mostrarAlumnos() throws Exception;

	void guardarTxtAlumnos() throws Exception;

	void leerTxtAlumnos() throws Exception;

	int cambiarNombre(int id) throws Exception;

	void borrarPorPK(int id) throws Exception;

	void borrarPorApellido(Alumno al) throws Exception;

	void borrarAlumnosDeGrupo(Grupo gp) throws Exception;

	void guardarXmlGrupos(Alumno al) throws Exception;

	void leerXmlGrupos(Alumno al) throws Exception;
}