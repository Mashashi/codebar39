import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import codebar.thirtynine.CodeBar39;
import codebar.EncodingAttr;

/**
 * 
 * @version Rafael Campos 2009.09.25
 * 
 */
@SuppressWarnings("serial")
public class CodeBar39Tester extends JFrame{
	
	public CodeBar39Tester(){
		
		super("Cod barras 39");
		
		setSize(500,500);
		
		try {
			
			LinkedList<EncodingAttr> attrs = new LinkedList<EncodingAttr>();
			
			attrs.add(EncodingAttr.BAR_CODE);
			attrs.add(EncodingAttr.PLAIN_TEXT);
			//attrs.add(EncodingAttr.HIDE_START_STOP);
			
			attrs.add(EncodingAttr.CHECK_DIGIT);
			
			CodeBar39 codebar = new CodeBar39("27519", attrs,5, 100, 18);
			
			codebar.buildCodeBar();
			
			add(new JLabel(codebar.getImageCodeBar()));	
			
		} catch (CodeBar39.IllegalCodeBar39Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		new CodeBar39Tester();
	
	}
	
}
