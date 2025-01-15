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

	int cambiarNombre(Alumno al) throws Exception;

	void borrarPorPK(int id) throws Exception;

	void borrarPorApellido(String apellido) throws Exception;

	void borrarAlumnosDeGrupo(int id_grupo) throws Exception;

	void guardarXmlGrupos() throws Exception;

	void leerXmlGrupos() throws Exception;
}