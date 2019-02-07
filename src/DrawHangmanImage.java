/**
 * 
 */

/**
 * @author user
 *
 */
public class DrawHangmanImage {
	
	private static String line1;
	private static String line2;
	private static String line3;
	private static String line4;
	private static String line5;
	private static String line6;
	
	
	
	public static String draw2(int status) {
	switch (status) {
		case 0:
			line1 = "";
			line2 = "";
			line3 = "";
			line4 = "";
			line5 = "";
			line6 = "";
			break;
			
		case 1:
			line1 = "";
			line2 = "";
			line3 = "";
			line4 = "";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 2:
			line1 = "";
			line2 = "";
			line3 = "";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
			
		case 3:
			line1 = "";
			line2 = "";
			line3 = "      | ";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
		
		case 4:
			line1 = "";
			line2 = "      | ";
			line3 = "      | ";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 5:
			line1 = "     _ ";
			line2 = "      | ";
			line3 = "      | ";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 6:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "      | ";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 7:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "      | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 8:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "   /  | ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 9:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "   / \\| ";
			line5 = "      | ";
			line6 = "      |_";
			break;
			
		case 10:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "   /|\\| ";
			line5 = "      | ";
			line6 = "      |_";
			break;
		
		case 11:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "   /|\\| ";
			line5 = "     \\| ";
			line6 = "      |_";
			break;
			
		case 12:
			line1 = "     _ ";
			line2 = "    | | ";
			line3 = "    o | ";
			line4 = "   /|\\| ";
			line5 = "    (\\| ";
			line6 = "      |_";
			break;
	
	}
		
	
	return line1 + "\n" + line2 + "\n" +line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n";
	}
			
}
