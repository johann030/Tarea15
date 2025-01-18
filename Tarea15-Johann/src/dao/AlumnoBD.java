package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
				INSERT INTO alumnos(NIA, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, id_grupo)
				VALUES (?,?,?,?,?,?,?,?)
				""";

		int resultado;

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, al.getNia());
			ps.setString(2, al.getNombre());
			ps.setString(3, al.getApellidos());
			ps.setString(4, al.getGenero());
			ps.setDate(5, Date.valueOf(al.getNacimiento()));
			ps.setString(6, al.getCiclo());
			ps.setString(7, al.getCurso());
			ps.setInt(8, al.getId_grupo());

			resultado = ps.executeUpdate();
		}
		return resultado;
	}

	@Override
	public int insertarGrupo(Grupo gp) throws Exception {
		String sql = """
				INSERT INTO grupos(id_grupo, nombre_grupo, aula)
				VALUES (?,?,?)
				""";

		int resultado;

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, gp.getId_grupo());
			ps.setString(2, gp.getNombre());
			ps.setInt(3, gp.getAula());

			resultado = ps.executeUpdate();
		}
		return resultado;
	}

	@Override
	public List<Alumno> mostrarAlumnos() throws Exception {
		String sql = """
				SELECT NIA, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, id_grupo
				FROM alumnos
				""";

		ArrayList<Alumno> resultado = new ArrayList<>();

		try (Connection conn = Conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			Alumno al;

			while (rs.next()) {
				al = new Alumno();
				al.setNia(rs.getInt("NIA"));
				al.setNombre(rs.getString("nombre"));
				al.setApellidos(rs.getString("apellidos"));
				al.setGenero(rs.getString("genero"));
				al.setNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				al.setCiclo(rs.getString("ciclo"));
				al.setCurso(rs.getString("curso"));
				al.setId_grupo(rs.getInt("id_grupo"));

				resultado.add(al);
			}
		}
		return resultado;
	}

	@Override
	public void guardarTxtAlumnos() throws Exception {
		String sql = """
				SELECT NIA, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, id_grupo
				FROM alumnos
				""";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("alumnos.txt"));
				Connection conn = Conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				bw.write(String.format("%d, %s, %s, %s, %s, %s, %s, %d", rs.getInt("NIA"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("genero"), rs.getDate("fecha_nacimiento").toLocalDate(),
						rs.getString("ciclo"), rs.getString("curso"), rs.getInt("id_grupo")));
				bw.newLine();
			}

			System.out.println("Se han guardado los alumnos correctamente.");

		}
	}

	@Override
	public void leerTxtAlumnos() throws Exception {
		String sql = """
				INSERT INTO alumnos(NIA, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, id_grupo)
				VALUES (?,?,?,?,?,?,?,?)
				""";

		String lineas;
		try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));
				Connection conn = Conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			while ((lineas = br.readLine()) != null) {
				String[] alumnoData = lineas.split(",");
				int nia = Integer.parseInt(alumnoData[0]);
				String nombre = alumnoData[1].trim();
				String apellidos = alumnoData[2].trim();
				String genero = alumnoData[3].trim();
				String fechaNacimiento = alumnoData[4].trim();
				String ciclo = alumnoData[5].trim();
				String curso = alumnoData[6].trim();
				int id_grupo = Integer.parseInt(alumnoData[7].trim());

				ps.setInt(1, nia);
				ps.setString(2, nombre);
				ps.setString(3, apellidos);
				ps.setString(4, genero);
				ps.setDate(5, Date.valueOf(fechaNacimiento));
				ps.setString(6, ciclo);
				ps.setString(7, curso);
				ps.setInt(8, id_grupo);

				ps.executeUpdate();
			}
		}
	}

	@Override
	public int cambiarNombre(String nombre, int id) throws Exception {
		String sql = """
				UPDATE alumnos
				SET nombre = ?
				WHERE NIA = ?
				""";

		int resultado;

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nombre);
			ps.setInt(2, id);

			resultado = ps.executeUpdate();
		}
		return resultado;
	}

	@Override
	public void borrarPorPK(int id) throws Exception {
		String sql = """
				DELETE FROM alumnos
				WHERE NIA = ?
				""";

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}

	@Override
	public void borrarPorApellido(String apellido) throws Exception {
		String sql = """
				DELETE FROM alumnos
				WHERE apellidos like ?
				""";

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + apellido + "%");
			ps.executeUpdate();
		}
	}

	@Override
	public void borrarAlumnosPorCurso(String curso) throws Exception {
		String sql = """
				DELETE FROM alumnos
				WHERE id_grupo = ?
				""";

		try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, curso);
			ps.executeUpdate();
		}
	}

	@Override
	public void guardarJSONGrupos() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void leerJSONGrupos() throws Exception {
		// TODO Auto-generated method stub

	}

	public void mostrarCursos() throws Exception {
		String sql = """
				SELECT curso
				FROM alumnos
				GROUP BY curso
				""";
		try (Connection conn = Conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getString("curso"));
			}
		}
	}
}