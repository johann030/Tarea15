package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import modelo.Alumno;
import modelo.Grupo;
import pool.Conexion;

public class AlumnoBD implements AlumnoDao {

	private static AlumnoBD instance;

	static {
		instance = new AlumnoBD();
	}

	private AlumnoBD() {
	}

	public static AlumnoBD getInstance() {
		return instance;
	}

	@Override
	public int insertarAlumno(Alumno al) throws Exception {
		String sql = """
				INSERT INTO alumnos(NIA, nombre, apellidos, genero, fecha_nacimiento, id_grupo)
				VALUES (?,?,?,?,?,?)
				""";

		int resultado;

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, al.getNia());
			ps.setString(2, al.getNombre());
			ps.setString(3, al.getApellidos());
			ps.setString(4, al.getGenero());
			ps.setDate(5, Date.valueOf(al.getNacimiento()));
			ps.setInt(6, al.getId_grupo());

			resultado = ps.executeUpdate();
		}
		return resultado;
	}

	@Override
	public int insertarGrupo(Grupo gp) throws Exception {
		String sql = """
				INSERT INTO grupos(nombre_grupo, ciclo, aula)
				VALUES (?,?,?)
				""";

		int resultado;

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, gp.getNombre());
			ps.setString(2, gp.getCiclo());
			ps.setInt(3, gp.getAula());

			resultado = ps.executeUpdate();
		}
		return resultado;
	}

	@Override
	public List<Alumno> mostrarAlumnos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTxtAlumnos() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void leerTxtAlumnos() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int cambiarNombre(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void borrarPorPK(int id) throws Exception {
		String sql = """
				DELETE FROM alumnos
				WHERE id = ?
				""";

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}

	@Override
	public void borrarPorApellido(Alumno al) throws Exception {
		String sql = """
				DELETE FROM alumnos
				WHERE apellidos like ?
				""";

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + al.getApellidos() + "%");
			ps.executeUpdate();
		}
	}

	@Override
	public void borrarAlumnosDeGrupo(Grupo gp) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarXmlGrupos(Alumno al) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void leerXmlGrupos(Alumno al) throws Exception {
		// TODO Auto-generated method stub

	}

}