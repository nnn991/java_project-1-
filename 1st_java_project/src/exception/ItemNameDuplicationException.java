package exception;

public class ItemNameDuplicationException extends Exception{

	public ItemNameDuplicationException() {}
	
	public ItemNameDuplicationException(String m) {
		super(m);
	}
}
