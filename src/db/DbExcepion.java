package db;

public class DbExcepion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbExcepion(String msg) {
		super(msg);
	}

}
