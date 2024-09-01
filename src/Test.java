import jeca.any.PrintArrayTool;
import jeca.any.PrintArrayToolStatic;

public class Test {

	public static void main(String[] args) {
		PrintArrayTool pat = new PrintArrayTool();
		
		String[] strArr = {
				"김큐엘",
				"정디비",
				"자바스",
				"나이썬"
		};
		
		pat.printArray(strArr);
		
		PrintArrayToolStatic.printArray(strArr);
	}

}
