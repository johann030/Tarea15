package dao;

public class AlumnoDaoImpl {

	private static AlumnoDaoImpl instance;

	static {
		instance = new AlumnoDaoImpl();
	}

	private AlumnoDaoImpl() {
	}

	public static AlumnoDaoImpl getInstance() {
		return instance;
	}

}