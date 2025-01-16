package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;


public class VistaConsola implements IVista{

	private reader reader;

	public VistaConsola() {
		reader = new reader();
	}

	public void init() {

		int opcion;

		do {
			menu();
			opcion = reader.nextInt();

			switch (opcion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				System.out.println("\nSaliendo del programa...\n");
				break;
			default:
				System.err.println("\nLa opcion dada no corresponde a una operacion valida.");
			}

		} while (opcion != 12);
	}

	public void menu() {
		System.out.println("GESTION DE ALUMNOS\n");
		System.out.println("------------------");
		System.out.println("1: Insertar alumnos.");
		System.out.println("2: Insertar grupos.");
		System.out.println("3: Mostrar alumnos.");
		System.out.println("4: Guardar los alumnos en un fichero.");
		System.out.println("5: Leer los alumnos de un fichero.");
		System.out.println("6: Modificar el nombre de un alumno por su PK.");
		System.out.println("7: Eliminar un alumno por su PK.");
		System.out.println("8: Eliminar un alumno por su apellido.");
		System.out.println("9: Eliminar los alumnos por su curso.");
		System.out.println("10: Guardar los grupos en un fichero.");
		System.out.println("11: Leer los grupos de un fichero.");
		System.out.println("12: Salir.");
		System.out.println("------------------\n");
		System.out.println("¿Que opcion elige?");
	}

	static class reader {

		BufferedReader br;
		StringTokenizer st;

		public reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException ex) {
					System.err.println("Error de lectura.");
					ex.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		LocalDate nextLocalDate() {
			return LocalDate.parse(next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}

		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreElements()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch (IOException e) {
				System.err.println("Error de lectura.");
				e.printStackTrace();
			}
			return str;
		}

	}
}
