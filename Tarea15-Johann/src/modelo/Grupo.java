package modelo;

import java.util.Objects;

public class Grupo {
	private int codigoGrupo;
	private String nombre;
	private int aula;

	public Grupo() {

	}

	public Grupo(int codigo) {
		this.codigoGrupo = codigo;
	}

	public Grupo(int codigo, String nombre, int aula) {
		this.codigoGrupo = codigo;
		this.nombre = nombre;
		this.aula = aula;
	}

	public int getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAula() {
		return aula;
	}

	public void setAula(int aula) {
		this.aula = aula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aula, codigoGrupo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return aula == other.aula && codigoGrupo == other.codigoGrupo && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Grupo [codigoGrupo=" + codigoGrupo + ", nombre=" + nombre + ", aula=" + aula + "]";
	}
}