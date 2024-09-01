package jeca.console;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 콘솔창 출력 프로그램 제작에 사용될 로직 모음. 
 * 사용자로부터 데이터 입력 받을 때 Scanner 클래스를 사용하였기에 
 * 두 개 이상의 연속된 문자열을 입력받을 수 있다.
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
 * @see {@link console.ConsoleUiNonScanner}
 */
public class ConsoleUiScanner {
	private String userInput;
	private String userInputIgnored;
	private String exitChar;
	private boolean exitCharIgnored = false;
	private int userInputInt;
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * 사용자로부터 입력받은 문자열을 반환.
	 * 
	 * 제대로 된 결과를 반환받기 위해, requestUserInput() 
	 * 메서드를 먼저 사용하여 사용자로부터 문자열을 입력받는 작업이 
	 * 선행되어야 한다. 
	 * 
	 * @return 사용자로부터 입력받은 문자열을 반환.
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public String getUserInput() {
		return userInput;
	}
	
	/**
	 * 사용자로부터 입력받은 문자열이 영어일 경우, 
	 * 모든 문자들을 소문자로 하여 반환. 
	 * 
	 * 제대로 된 결과를 반환받기 위해, requestUserInput() 
	 * 메서드를 먼저 사용하여 사용자로부터 문자열을 입력받을 것.
	 * 
	 * @return 사용자로부터 입력받은 문자열을 반환.
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public String getUserInputLowerCase() {
		return userInputIgnored;
	}
	
	/**
	 * 사용자로부터 입력받은 정수형 문자열의 자료형을 
	 * int 형으로 변환하여 반환.
	 * 
	 * 제대로 된 결과를 반환받기 위해, requestUserInputInt() 
	 * 메서드를 먼저 사용하여 사용자로부터 문자열을 입력받을 것.
	 * 
	 * @return 사용자로부터 입력받은 정수형 문자열을 정수형으로 반환.
	 * @see {@link #requestUserInputInt()}
	 * @see {@link #requestUserInputInt(String)}
	 */
	public int getUserInputInt() {
		return userInputInt;
	}
	
	/**
	 * 사용자로부터 문자열을 입력받게 한다. 
	 * 
	 * 입력받은 문자열을 얻고자 한다면 getUserInput() 또는 
	 * getUserInputLowerCase() 
	 * 메서드를 호출하여 반환받을 것.
	 * 
	 * @see {@link #getUserInput()}
	 * @see {@link #getUserInputLowerCase()}
	 */
	public void requestUserInput() {
		System.out.print("입력: ");
		userInput = scan.next();
		userInputIgnored = userInput.toLowerCase();
	}
	
	/**
	 * 사용자로부터 문자열을 입력받게 한다. 
	 * 
	 * 입력받은 문자열을 얻고자 한다면 getUserInput() 또는 
	 * getUserInputLowerCase() 
	 * 메서드를 호출하여 반환받을 것.
	 * 
	 * @param prompt - 사용자에게 출력하여 보여줄 메시지
	 * @see {@link #getUserInput()}
	 * @see {@link #getUserInputLowerCase()}
	 */
	public void requestUserInput(String prompt) {
		System.out.print(prompt);
		userInput = scan.next();
		userInputIgnored = userInput.toLowerCase();
	}
	
	/**
	 * 사용자로부터 정수형 문자열을 입력받게 한다. 
	 * Scanner를 내부적으로 사용하므로, 두 자리 수 이상의 정수형 수를 
	 * 입력받을 수 있다. 
	 * 
	 * 사용자로부터 입력받은 정수형 문자열을 정수형으로 반환받고자 한다면 
	 * {@link #getUserInputInt()} 메서드를 호출하면 된다. 
	 * 
	 * @return
	 * <ul>
	 * <li> 
	 *     true : 사용자가 정수형 문자열을 입력하였을 경우.
	 * </li>
	 * <li>
	 * 	   false : 사용자가 정수형이 아닌 문자열을 입력한 경우.
	 * </li>
	 * @see {@link #getUserInputInt()}
	 */
	public boolean requestUserInputInt() {
		System.out.print("숫자 입력: ");
		try {
			userInputInt = scan.nextInt();
			userInput = String.valueOf(userInputInt);
		} catch(InputMismatchException imex) {
			return false;
		}
		return true;
	}
	
	/**
	 * 사용자로부터 정수형 문자열을 입력받게 한다. 
	 * Scanner를 내부적으로 사용하므로, 두 자리 수 이상의 정수형 수를 
	 * 입력받을 수 있다. 
	 * 
	 * 사용자로부터 입력받은 정수형 문자열을 정수형으로 반환받고자 한다면 
	 * {@link #getUserInputInt()} 메서드를 호출하면 된다. 
	 * 
	 * @param prompt - 입력 전 사용자에게 보여줄 입력 관련 메시지.
	 * @return
	 * <ul>
	 * <li> 
	 *     true : 사용자가 정수형 문자열을 입력하였을 경우.
	 * </li>
	 * <li>
	 * 	   false : 사용자가 정수형이 아닌 문자열을 입력한 경우.
	 * </li>
	 * @see {@link #getUserInputInt()}
	 */
	public boolean requestUserInputInt(String prompt) {
		System.out.print(prompt);
		try {
			userInputInt = scan.nextInt();
			userInput = String.valueOf(userInputInt);
		} catch(InputMismatchException imex) {
			return false;
		}
		return true;
	}
	
	/**
	 * 이미 {@link #requestUserInput()} 등의 메서드 호출로 인해 
	 * 사용자로부터 문자형 형태로 데이터를 입력받은 경우, 
	 * 이후에 정수형으로 변환하기 위한 메서드. 
	 * 
	 * @return
	 * <ul>
	 * <li> 
	 *     true : 사용자가 정수형 문자열을 입력하였을 경우.
	 * </li>
	 * <li>
	 * 	   false : 사용자가 정수형이 아닌 문자열을 입력한 경우.
	 * </li>
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public boolean convertStringToInt() {
		try {
			userInputInt = Integer.parseInt(userInput);
		} catch(NumberFormatException nfex) {
			return false;
		}
		return true;
	}
	
	/**
	 * 콘솔 프로그램을 종료하기 위한 문자열을 등록하는 메서드. 
	 * 이후 사용자가 특정 문자열을 입력하면 프로그램을 종료할 수 있도록 
	 * 해당 문자열을 미리 등록한다. 
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
	 * console.registerExitChar("x", true);
	 * 
	 * while(true) {
	 *     console.requestUserInput("아무 문자나 입력: ");
	 *     if (console.isExitChar("프로그램을 종료합니다.")) return;
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param exit - 콘솔 프로그램 종료에 사용할 문자열. 두 글자 이상 입력해도 됨.
	 * @param ignoreCase - 영어일 경우 대소문자를 구별할 것인지 여부. 
	 * <ul>
	 * <li>
	 *     true - 사용자가 대문자를 섞어 입력해도 프로그램 종료 문자열로 인식.
	 * </li>
	 * <li>
	 *     false - 사용자가 대문자(또는 소문자)를 입력하면 프로그램 종료 문자열로 
	 *     인식시키지 않는다. 
	 * </li>
	 * </ul>
	 */
	public void registerExitChar(String exit, boolean ignoreCase) {
		if (ignoreCase) {
			exitChar = exit.toLowerCase();
		} else {
			exitChar = exit;
		}
		exitCharIgnored = ignoreCase;
	}
	
	/**
	 * 사용자가 입력한 문자열이 프로그램 종료를 위한 문자열인지 확인하는 메서드.
	 * 
	 * 이전에 미리 {@link #registerExitChar(String, boolean)} 메서드로 
	 * 프로그램 종료 문자열을 등록한 후, {@link #requestUserInput()} 메서드로 
	 * 사용자로부터 문자열을 입력받은 상태여야 제대로 사용할 수 있다. 
	 * 
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 프로그램 종료 문자열을 입력한 경우. 
	 *     이 때 개발자는 프로그램이 즉시 종료될 수 있도록 코드를 짤 수 있다. 
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 프로그램 종료 문자열이 아닌 경우.
	 * </li>
	 * </ul>
	 * @see {@link #registerExitChar(String, boolean)}
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public boolean isExitChar() {
		String userInput = null;
		
		if (exitCharIgnored) {
			userInput = userInputIgnored;
		} else {
			userInput = this.userInput;
		}
		
		if (userInput.equals(exitChar)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자열이 프로그램 종료를 위한 문자열인지 확인하는 메서드.
	 * 
	 * 이전에 미리 {@link #registerExitChar(String, boolean)} 메서드로 
	 * 프로그램 종료 문자열을 등록한 후, {@link #requestUserInput()} 메서드로 
	 * 사용자로부터 문자열을 입력받은 상태여야 제대로 사용할 수 있다. 
	 * 
	 * @param exitMsg - 개발자가 프로그램 종료 로직을 마련하였고, 사용자가 
	 * 프로그램 종료 문자열을 입력한 경우, 프로그램 종료 직전에 사용자에게 보여줄 
	 * 메시지. 예) "프로그램을 종료합니다."
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 프로그램 종료 문자열을 입력한 경우. 
	 *     이 때 개발자는 프로그램이 즉시 종료될 수 있도록 코드를 짤 수 있다. 
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 프로그램 종료 문자열이 아닌 경우.
	 * </li>
	 * </ul>
	 * @see {@link #registerExitChar(String, boolean)}
	 * @see {@link #requestUserInput()}
	 * @see {@link #requestUserInput(String)}
	 */
	public boolean isExitChar(String exitMsg) {
		String userInput = null;
		
		if (exitCharIgnored) {
			userInput = userInputIgnored;
		} else {
			userInput = this.userInput;
		}
		
		if (userInput.equals(exitChar)) {
			System.out.println(exitMsg);
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 정수형 문자 하나가 특정 정수형 숫자 범위 내에 있는지 확인하기 위한 
	 * 메서드. 
	 * <br>
	 * 예시) <br>
	 * <pre>
	 * <code>
	 * ConsoleUiScanner console = new ConsoleUiScanner();
	 * console.registerExitChar("3", true);
	 * 
	 * while(true) {
	 *     System.out.println("=== 메뉴 선택 ===");
	 *     System.out.println("1. 실행");
	 *     System.out.println("2. 설정");
	 *     System.out.println("3. 종료");
	 *     console.requestUserInputInt();
	 *     if (!console.isInRange(1, 3)) {
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
	 * @param startNum - 범위의 시작 숫자.
	 * @param endNum - 범위의 마지막 숫자.
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 입력한 정수형 문자 하나가 startNum, endNum으로 
	 *     지정된 숫자 범위 내에 있을 경우.
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자 하나가 정수형이 아니거나 지정된 범위 내에 
	 *     있지 않을 경우.
	 * </li>
	 * </ul>
	 */
	public boolean isInRange(int startNum, int endNum) {
		if (startNum > endNum) {
			int temp = startNum;
			startNum = endNum;
			endNum = temp;
		}
		
		try {
			Integer.parseInt(userInput);
		} catch (InputMismatchException imex) {
			return false;
		}
		
		if (startNum <= userInputInt &&
			userInputInt <= endNum) {
			return true;
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자 하나 또는 두 글자 이상의 문자열이 
	 * 지정된 문자열들 중에 포함되는지 확인하는 메서드. 
	 * 
	 * @param choices - 검사할 대조 문자열 목록.
	 * @return
	 * <ul>
	 * <li>
	 *     true - 사용자가 입력한 문자열이 choices 배열 중에 포함되어 있을 경우.
	 * </li>
	 * <li>
	 *     false - 사용자가 입력한 문자열이 choices 배열 내에 없을 경우.
	 * </li>
	 * </ul>
	 */
	public boolean isInRange(String[] choices) {
		for (String ch : choices) {
			if (userInput.equals(ch)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 사용자가 입력한 문자열이 "y" 또는 "n" 중 (대소문자 구별 안 함) 
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
		if (userInputIgnored.equals("y") || userInputIgnored.equals("n")) {
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
		if (userInputIgnored.equals("y")) {
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
