package in.vaibhav.springbootmongodb.exception;

public class WolfCollectionExeception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WolfCollectionExeception(String message) {
		super(message);
		
		
	}
	public static String NotFoundException(String id) {
		return "Wolf with"+id+"not found!";
	}
	public static String WolfAlreadyExists() {
		return "Wolf with given name already exists";
	}
	

}
