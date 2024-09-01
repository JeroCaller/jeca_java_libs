package jeca.console;

import java.io.IOException;

/**
 * 콘솔창 출력 프로그램 제작에 사용될 로직 모음.
 * 사용자로부터 한 번에 단 한 문자만 입력받도록 할 수 있다. 
 * 
 * <div>
 * 제작자 정보
 * <ul>
 * <li>
 * <a href="https://github.com/JeroCaller">Author's Github</a>
 * </li>
 * <li>
 * <a href="https://jerocaller.github.io">Author's blog</a>
 * </li>
 * </div>
 * 
 * @author JeroCaller 
 * @see {@link console.ConsoleUiScanner}
 */
public class ConsoleUiNonScanner {
	private char userInputInChar;
	private int userInputInInt;
	private char userInputIgnored;
	private char exitChar;
	private boolean exitCharIgnored = false;
	
	/**
	 * 사용자로부터 입력받은 문자 하나를 char형으로 반환.
	 * 
	 * 제대로 된 결과를 반환받기 위해, {@link #requestUserInput()} 
	 * 메서드를 먼저 사용하여 사용자로부터 문자 하나를 입력받는 작업이 
	 * 선행되어야 한다. 
	 * 
	 * @return 사용자로부터 입력받은 문자 하나를 char형으로 반환.
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public char getUserInputInChar() {
		return userInputInChar;
	}
	
	/**
	 * 사용자로부터 입력받은 문자 하나를 int형의 아스키 코드로 반환.
	 * 
	 * 제대로 된 결과를 반환받기 위해, {@link #requestUserInput()} 
	 * 메서드를 먼저 사용하여 사용자로부터 문자 하나를 입력받는 작업이 
	 * 선행되어야 한다. 
	 * @return 사용자로부터 입력받은 문자 하나를 ASCII 코드 형태의 int형으로 반환.
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public int getUserInputInInt() {
		return userInputInInt;
	}
	
	/**
	 * 사용자로부터 문자 하나를 입력받는다. 
	 * 사용자로부터 입력받은 문자 하나를 얻고자 한다면 이 클래스의 
	 * {@link #getUserInputInChar()} 또는 {@link #getUserInputInChar()} 
	 * 메서드를 호출하여 사용한다. 
	 * 
	 * @throws IOException
	 * @see {@link #getUserInputInChar()}
	 * @see {@link #getUserInputInInt()}
	 * @see {@link #requestUserInput(String)}
	 */
	public void requestUserInput() throws IOException {
		System.out.print("키보드로 문자 하나 입력: ");
		userInputInInt = System.in.read();
		System.in.skip(2);
		userInputInChar = (char)userInputInInt;
		userInputIgnored = Character.toLowerCase(userInputInChar);
	}
	
	/**
	 * 사용자로부터 문자 하나를 입력받는다. 
	 * 사용자로부터 입력받은 문자 하나를 얻고자 한다면 이 클래스의 
	 * {@link #getUserInputInChar()} 또는 {@link #getUserInputInChar()} 
	 * 메서드를 호출하여 사용한다. 
	 * 
	 * @param prompt - 사용자로부터 문자를 입력받기 전 사용자에게 보여줄 메시지.
	 * @throws IOException
	 * @see {@link #getUserInputInChar()}
	 * @see {@link #getUserInputInInt()}
	 * @see {@link #requestUserInput(String)}
	 */
	public void requestUserInput(String prompt) throws IOException {
		System.out.print(prompt);
		userInputInInt = System.in.read();
		System.in.skip(2);
		userInputInChar = (char)userInputInInt;
		userInputIgnored = Character.toLowerCase(userInputInChar);
	}
	
	/**
	 * 콘솔 프로그램을 종료하기 위한 문자를 등록하는 메서드. 
	 * 이후 사용자가 특정 문자를 입력하면 프로그램을 종료할 수 있도록 
	 * 해당 문자를 미리 등록한다. 
	 * 
	 * 실제 사용자가 특정 문자열을 입력하면 콘솔 프로그램이 종료되게끔 하는 
	 * 기능은 {@link #isExitChar()} 메서드와 if, return문과 결합하여 
	 * 사용해야 함. 
	 * 
	 * <br>
	 * 사용 예시)
	 * <br>
	 * <pre>
	 * <code>
	 * ConsoleUiScanner console = new ConsoleUiScanner();
	 * console.registerExitChar('x', true);
	 * 
	 * while(true) {
	 *     console.requestUserInput("아무 문자 하나 입력: ");
	 *     if (console.isExitChar("프로그램을 종료합니다.")) return;
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param exit - 프로그램 종료 문자로 등록할 문자 하나 입력.
	 * @param ignoreCase - 대소문자를 구별할 것인지 여부.
	 * <ul>
	 * <li>
	 *     true - 사용자가 대문자(또는 소문자)로 입력해도 프로그램 종료 문자열로 인식.
	 * </li>
	 * <li>
	 *     false - 사용자가 대문자(또는 소문자)를 입력하면 프로그램 종료 문자로 
	 *     인식시키지 않는다. 
	 * </li>
	 * </ul>
	 */
	public void registerExitChar(char exit, boolean ignoreCase) {
		if (ignoreCase) {
			exitChar = Character.toLowerCase(exit);
		} else {
			exitChar = exit;
		}
		exitCharIgnored = ignoreCase;
	}
	
	/**
	 * 사용자가 입력한 문자열이 프로그램 종료를 위한 문자열인지 확인하는 메서드.
	 * 
	 * 이전에 미리 {@link #registerExitChar(char, boolean)} 메서드로 
	 * 프로그램 종료 문자열을 등록한 후, {@link #requestUserInput()} 메서드로 
	 * 사용자로부터 문자열을 입력받은 상태여야 제대로 사용할 수 있다. 
	 * 
	 * @return 
	 * <ul>
	 * <li>
	 *     true - 사용자가 프로그램 종료 문자를 입력한 경우. 
	 *     이 때 개발자는 프로그램이 즉시 종료될 수 있도록 코드를 짤 수 있다. 
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 프로그램 종료 문자가 아닌 경우.
	 * </li>
	 * </ul>
	 * @see {@link #registerExitChar(char, boolean)}
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public boolean isExitChar() {
		char userInput;
		
		if (exitCharIgnored) {
			userInput = userInputIgnored;
		} else {
			userInput = userInputInChar;
		}
		
		if (userInput == exitChar) {
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자열이 프로그램 종료를 위한 문자열인지 확인하는 메서드.
	 * 
	 * 이전에 미리 {@link #registerExitChar(char, boolean)} 메서드로 
	 * 프로그램 종료 문자열을 등록한 후, {@link #requestUserInput()} 메서드로 
	 * 사용자로부터 문자열을 입력받은 상태여야 제대로 사용할 수 있다. 
	 * 
	 * @param exitMsg - 개발자가 프로그램 종료 로직을 마련하였고, 사용자가 
	 * 프로그램 종료 문자열을 입력한 경우, 프로그램 종료 직전에 사용자에게 보여줄 
	 * 메시지. 예) "프로그램을 종료합니다."
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 프로그램 종료 문자를 입력한 경우. 
	 *     이 때 개발자는 프로그램이 즉시 종료될 수 있도록 코드를 짤 수 있다. 
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 프로그램 종료 문자가 아닌 경우.
	 * </li>
	 * </ul>
	 * @see {@link #registerExitChar(char, boolean)}
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public boolean isExitChar(String exitMsg) {
		char userInput;
		
		if (exitCharIgnored) {
			userInput = userInputIgnored;
		} else {
			userInput = userInputInChar;
		}
		
		if (userInput == exitChar) {
			System.out.println(exitMsg);
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자가 지정된 문자 범위 내에 있는지 확인하는 메서드. 
	 * 
	 * <br>
	 * 예시) <br>
	 * <pre>
	 * <code>
	 * ConsoleUiNonScanner console = new ConsoleUiNonScanner();
	 * console.registerExitChar('3', true);
	 * 
	 * while(true) {
	 *     System.out.println("=== 메뉴 선택 ===");
	 *     System.out.println("1. 실행");
	 *     System.out.println("2. 설정");
	 *     System.out.println("3. 종료");
	 *     console.requestUserInput();
	 *     if (!console.isInRange('1', '3')) {
	 *         System.out.println("1, 2, 3중 하나를 입력하세요.");
	 *         continue;
	 *     }
	 *     if (console.isExitChar("프로그램을 종료합니다.")) {
	 *         return;
	 *     }
	 *     
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param startChar - 범위의 시작 문자 (ASCII 코드표 기준)
	 * @param endChar - 범위의 끝 문자
	 * @return
	 */
	public boolean isInRange(char startChar, char endChar) {
		if (startChar > endChar) {
			char temp = startChar;
			startChar = endChar;
			endChar = temp;
		}
		
		if (startChar <= userInputInChar &&
			userInputInChar <= endChar) {
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자가 'y' 또는 'n' 중 (대소문자 구별 안 함) 
	 * 하나라도 포함되어 있는지 확인하는 메서드.
	 * 
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 입력한 문자열이 "y" 또는 "n" 중에 포함되어 있을 경우.
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 "y" 또는 "n" 중에 포함되어 있지 않을 경우.
	 * </li>
	 * </ul>
	 */
	public boolean isInYesOrNo() {
		if (userInputIgnored == 'y' || userInputIgnored == 'n') {
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자열이 "y" 또는 "n"일 때 
	 * "y"이면 true를, "n"이거나 그 외 문자열일 경우 false를 반환하는 메서드.
	 * @return
	 */
	public boolean getYesNoIntoBool() {
		if (userInputIgnored == 'y') {
			return true;
		}
		return false;
	}
	
	/**
	 * 개행 메서드. 콘솔창에서 빈 한 줄 형성에 사용될 수 있다.
	 */
	public void printNewLine() {
		System.out.println();
	}
	
	/**
	 * 개행 메서드. 콘솔창에서 빈 한 줄 형성에 사용될 수 있다.
	 * @param repeat - 몇 줄을 개행할 것인지 정수형으로 입력. 
	 */
	public void printNewLine(int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println();
		}
	}
	
}
