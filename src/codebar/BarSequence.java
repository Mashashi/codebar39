package codebar;

/**
 * 
 * @version Rafael Campos 2009.09.25
 *
 */
public interface BarSequence {
	
	public Character getRepresentation();
	
	public Bar[] getSequence();
	
	public int getWidth(int scale);
	
}
