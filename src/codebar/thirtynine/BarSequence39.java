package codebar.thirtynine;

import codebar.Bar;
import codebar.BarSequence;

/**
 * @version Rafael Campos 2009.09.25
 * 
 * Código de barras 39
 * http://en.wikipedia.org/wiki/Barcode
 * http://en.wikipedia.org/wiki/Code_39
 */
public enum BarSequence39 implements BarSequence{
	
	zero('0', Bar.b,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.B,Bar.w,Bar.b),
	one('1', Bar.B,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B),
	two('2', Bar.b, Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B),
	three('3',Bar.B,Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.b),
	four('4', Bar.b,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.B),
	five('5', Bar.B,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b),
	six('6', Bar.b,Bar.w,Bar.B,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b), 
	seven('7', Bar.b,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.B),
	eight('8', Bar.B,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b),
	nine('9', Bar.b,Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b),
	A('A',Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.B),
	B('B',Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.B),
	C('C',Bar.B,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.b,Bar.w,Bar.b),
	D('D',Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.B),
	E('E',Bar.B,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.b),
	F('F',Bar.b,Bar.w,Bar.B,Bar.w,Bar.B,Bar.W,Bar.b,Bar.w,Bar.b),
	G('G',Bar.b,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.B),
	H('H',Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.b),
	I('I',Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.B,Bar.w,Bar.b),
	J('J',Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.B,Bar.w,Bar.b),
	K('K',Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.B),
	L('L',Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.B),
	M('M',Bar.B,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.W,Bar.b),
	N('N',Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.B),
	O('O',Bar.B,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.b),
	P('P',Bar.b,Bar.w,Bar.B,Bar.w,Bar.B,Bar.w,Bar.b,Bar.W,Bar.b),
	Q('Q',Bar.b,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.B),
	R('R',Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.b),
	S('S',Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.B,Bar.W,Bar.b),
	T('T',Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.B,Bar.W,Bar.b),
	U('U',Bar.B,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B),
	V('V',Bar.b,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B),
	W('W',Bar.B,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b,Bar.w,Bar.b),
	X('X',Bar.b,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.B),
	Y('Y',Bar.B,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b),
	Z('Z',Bar.b,Bar.W,Bar.B,Bar.w,Bar.B,Bar.w,Bar.b,Bar.w,Bar.b),
	hyphen('-',Bar.b,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.B),
	dot('.',Bar.B,Bar.W,Bar.b,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b),
	space(' ',Bar.b,Bar.W,Bar.B,Bar.w,Bar.b,Bar.w,Bar.B,Bar.w,Bar.b),
	dolar('$',Bar.b,Bar.W,Bar.b,Bar.W,Bar.b,Bar.W,Bar.b,Bar.w,Bar.b),
	slash('/',Bar.b,Bar.W,Bar.b,Bar.W,Bar.b,Bar.w,Bar.b,Bar.W,Bar.b),
	plus('+',Bar.b,Bar.W,Bar.b,Bar.w,Bar.b,Bar.W,Bar.b,Bar.W,Bar.b),
	percentage('%',Bar.b,Bar.w,Bar.b,Bar.W,Bar.b,Bar.W,Bar.b,Bar.W,Bar.b),
	start_and_stop(Bar.b,Bar.W,Bar.b,Bar.w,Bar.B,Bar.w,Bar.B,Bar.w,Bar.b),
	spacement('|',Bar.w);
	
	private Character representation;

	private Bar[] sequence;

	private BarSequence39(final Character representation, final Bar... sequence) {

		this.sequence = sequence;

		this.representation = representation;

	}

	private BarSequence39(final Bar... sequence) {

		this.sequence = sequence;

		this.representation = null;

	}

	@Override
	public Character getRepresentation() {

		return representation;

	}

	@Override
	public Bar[] getSequence() {

		return sequence;

	}

	public static BarSequence39 getElement(final char c) {

		for (BarSequence39 barsequence39 : values()) {

			if (barsequence39.getRepresentation() != null
					&& barsequence39.getRepresentation() == c) {

				return barsequence39;
			}

		}

		return null;

	}

	/**
	 * @todo
	 * @param code
	 * @return
	 */
	public static boolean isValid(final String code) {

		return code.matches("[0-9A-Z\\.\\$\\- +%]*");

	}

	@Override
	public int getWidth(int scale) {

		int totalPixels = 0;

		for (Bar bar : sequence)

			totalPixels += bar.getWidth(scale);

		return totalPixels;

	}

	public static BarSequence39 valueOfRep(char c) {
		for (BarSequence39 barS : values()) {
			if (c == barS.getRepresentation()) {
				return barS;
			}
		}
		return null;
	}
}
