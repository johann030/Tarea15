package dao;

public class AlumnoBD {

	private static AlumnoBD instance;

	static {
		instance = new AlumnoBD();
	}

	private AlumnoBD() {
	}

	public static AlumnoBD getInstance() {
		return instance;
	}

}