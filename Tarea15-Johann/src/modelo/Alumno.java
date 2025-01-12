package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
	private int nia;
	private String nombre;
	private String apellidos;
	private String genero;
	private LocalDate nacimiento;
	private String ciclo;
	private String curso;
	private Grupo gp;

	public Alumno() {
	}

	public Alumno(int nia, String nombre, String apellidos, String genero, LocalDate nacimiento, String ciclo,
			String curso, Grupo nombreGrupo) {
		this.nia = nia;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.nacimiento = nacimiento;
		this.ciclo = ciclo;
		this.curso = curso;
		this.gp = nombreGrupo;
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Grupo getGp() {
		return gp;
	}

	public void setGp(Grupo gp) {
		this.gp = gp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, ciclo, curso, genero, gp, nacimiento, nia, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(ciclo, other.ciclo)
				&& Objects.equals(curso, other.curso) && Objects.equals(genero, other.genero)
				&& Objects.equals(gp, other.gp) && Objects.equals(nacimiento, other.nacimiento) && nia == other.nia
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", nacimiento=" + nacimiento + ", ciclo=" + ciclo + ", curso=" + curso + ", gp=" + gp + "]";
	}
}