package modelo;

public class Grupo {
	private int id_grupo;
	private String nombre;
	private String ciclo;
	private int aula;

	public Grupo() {
	}

	public Grupo(String nombre, String ciclo, int aula) {
		this.nombre = nombre;
		this.ciclo = ciclo;
		this.aula = aula;
	}

	public Grupo(int id_grupo, String nombre, String ciclo, int aula) {
		this(nombre, ciclo, aula);
		this.id_grupo = id_grupo;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getAula() {
		return aula;
	}

	public void setAula(int aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Grupo [id_grupo=" + id_grupo + ", nombre=" + nombre + ", ciclo=" + ciclo + ", aula=" + aula + "]";
	}
}