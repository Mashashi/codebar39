package codebar.thirtynine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import codebar.Bar;
import codebar.EncodingAttr;

/**
 * 
 * @version Rafael Campos 2009.09.25
 * @version Rafael Campos 2009.09.26 Fixed bug of EncodinAttr.HIDE_START_STOP
 * 
 *          http://www.guj.com.br/article.show.logic?id=34
 * 
 */
@SuppressWarnings("serial")
public class CodeBar39 {

	// Configurações
	private int picWidth;
	private int picHeight;

	// Input
	private String barCode;
	private LinkedList<EncodingAttr> attr;
	private int scale;
	private int barHeight;
	private int fontSize;

	// Geração
	private ImageIcon imageCodeBar;
	private boolean isPlainText;
	private boolean isBarCode;

	/**
	 * 
	 * @param barCode
	 * @throws IllegalCodeBar39Exception
	 */
	public CodeBar39(String barCode, final LinkedList<EncodingAttr> attr,
			final int scale, final int barHeight, int fontSize)
			throws IllegalCodeBar39Exception {

		this.scale = scale;

		if (!BarSequence39.isValid(barCode))
			throw new IllegalCodeBar39Exception();

		if (attr.contains(EncodingAttr.CHECK_DIGIT)) {
			long sum = 0;
			for (char charAt : barCode.toCharArray()) {
				sum += BarSequence39.valueOfRep(charAt).ordinal();
			}
			barCode += BarSequence39.values()[(int) (sum % 43)]
					.getRepresentation();
		}

		char[] charArray = barCode.toCharArray();
		barCode = "";
		for (char c : charArray) {
			barCode += "|" + c;
		}
		barCode += "|";

		isPlainText = attr.contains(EncodingAttr.PLAIN_TEXT);

		isBarCode = attr.contains(EncodingAttr.BAR_CODE);

		if (!isPlainText && !isBarCode)
			throw new IllegalArgumentException(
					"Defina pelo menos 1 atributo de formatação");

		this.barCode = barCode;

		this.attr = attr;

		this.imageCodeBar = null;

		picHeight = picWidth = 0;

		if (isPlainText) {

			picHeight += fontSize;

		}

		if (isBarCode) {

			picHeight += barHeight;

		}

		if (isPlainText || isBarCode) {

			picWidth += getCodeBarWidth();

		}

		this.barHeight = barHeight;
		this.fontSize = fontSize;
	}

	/**
	 * 
	 * @return
	 */
	public ImageIcon getImageCodeBar() {

		return imageCodeBar;

	}

	/**
	 * 
	 * @return
	 */
	public String getCodeBar() {

		return barCode;

	}

	/**
	 * 
	 * @return
	 */
	private int getCodeBarWidth() {

		int width = 0;

		for (int i = 0; i < barCode.length(); i++) {

			width += BarSequence39.getElement(barCode.charAt(i))
					.getWidth(scale);

		}

		return width + 2 * BarSequence39.start_and_stop.getWidth(scale);

	}

	/**
	 * 
	 * @param barCode
	 * @return
	 * @throws IllegalCodeBar39Exception
	 */
	public void buildCodeBar() {

		BufferedImage bufferImage = new BufferedImage(picWidth, picHeight,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = bufferImage.getGraphics();

		if (isPlainText)

			g.setFont(new Font("Arial", Font.PLAIN, fontSize));

		g.setColor(Color.WHITE);

		g.fillRect(0, 0, picWidth, picHeight);

		for (int i = 0; i < barCode.length(); i++) {

			drawBarCode(g, barCode);

		}

		imageCodeBar = new ImageIcon(bufferImage);

	}

	/**
	 * 
	 * @param g
	 * @param barCode
	 */
	private void drawBarCode(final Graphics g, final String barCode) {

		int startX = 0;

		if (isPlainText && !attr.contains(EncodingAttr.HIDE_START_STOP)) {

			g.setColor(Color.BLACK);

			g.drawString("*", startX, isBarCode ? barHeight + fontSize
					: fontSize);

		}

		if (isBarCode) {

			drawLines(g, startX, BarSequence39.start_and_stop.getSequence());

		}

		startX = BarSequence39.start_and_stop.getWidth(scale);

		for (int c = 0; c < barCode.length(); c++) {

			if (barCode.charAt(c) != BarSequence39.spacement
					.getRepresentation() && isPlainText) {

				g.setColor(Color.BLACK);

				g.drawString(barCode.charAt(c) + "", startX,
						isBarCode ? barHeight + fontSize : fontSize);

			}
			if (isBarCode) {

				drawLines(g, startX, BarSequence39
						.getElement(barCode.charAt(c)).getSequence());
			}

			startX += BarSequence39.getElement(barCode.charAt(c)).getWidth(
					scale);
		}

		if (isBarCode)

			drawLines(g, startX, BarSequence39.start_and_stop.getSequence());

		if (isPlainText && !attr.contains(EncodingAttr.HIDE_START_STOP)) {

			g.setColor(Color.BLACK);

			g.drawString("*", startX, isBarCode ? barHeight + fontSize
					: fontSize);

		}

	}

	/**
	 * 
	 * @param g
	 * @param startX
	 * @param toDraw
	 */
	private void drawLines(final Graphics g, int startX, final Bar[] toDraw) {
		
		for (Bar bar : toDraw) {

			g.setColor(bar.getColor());

			g.fillRect(startX, 0, bar.getWidth(scale), barHeight);

			startX += bar.getWidth(scale);

		}

	}

	/**
	 * @author Rafael Campos
	 * 
	 */
	public class IllegalCodeBar39Exception extends Exception {

		public IllegalCodeBar39Exception(final char c) {

			super("O caracter " + c + " não pode ser codificado");

		}

		public IllegalCodeBar39Exception() {

			super("Existe um caracter que não pode ser codificado");

		}

		public IllegalCodeBar39Exception(final String str) {

			super(str);

		}

	}

}
