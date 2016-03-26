package codebar;

import java.awt.Color;

/**
 * 
 * @version Rafael Campos 2009.09.25
 * 
 * 
 */
public enum Bar {

	w(1, Color.WHITE), W(2, Color.WHITE), ww(3, Color.white), WW(4, Color.white), 
	b(1, Color.BLACK), B(2, Color.BLACK), bb(3, Color.BLACK), BB(4, Color.BLACK);

	private int width;

	private Color color;

	private Bar(final int width, final Color color) {

		this.width = width;

		this.color = color;

	}

	public Color getColor() {

		return color;

	}

	public int getWidth(int scale) {
		return Math.round(width * scale);

	}

	public static Bar getElement(final char c) {

		for (Bar elem : values()) {

			if (elem.toString().equals("" + c))

				return elem;

		}

		return null;

	}

}