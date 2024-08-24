package console;

public class TestConsoleUiScanner {

	public static void main(String[] args) {
		ConsoleUiScanner console = new ConsoleUiScanner();
		console.registerExitChar("x", true);
		
		while(true) {
			System.out.println("=== 메뉴 선택 ===");
			System.out.println("1. 실행");
			System.out.println("2. 설정");
			System.out.println("3. 종료");
			System.out.println("x 입력 시 프로그램 종료.");
			console.requestUserInput();
			if (console.isExitChar("프로그램 종료.")) return;
			if (!console.convertStringToInt() || 
					!console.isInRange(1, 3)) {
				System.out.println("1, 2, 3중 하나를 입력하세요.");
				continue;
			}
			
			switch (console.getUserInputInt()) {
				case 1:
					System.out.println("1. 실행. 을 선택하셨습니다.");
					break;
				case 2:
					System.out.println("2. 설정. 을 선택하셨습니다.");
					console.printNewLine();
				
					console.requestUserInput("y/n: ");
					if(!console.isInYesOrNo()) {
						System.out.println("y 또는 n 중에 하나만 택했어야 했습니다.");
						continue;
					}
				
					System.out.print("당신의 답: ");
					if (console.getYesNoIntoBool()) {
						System.out.println("Yes");
					} else {
						System.out.println("no");
					}
					break;
				case 3:
					System.out.println("3. 종료. 를 선택하셨습니다.");
					break;
				default:
					System.out.println("뭐야 여긴 어떻게 왔어요?");
			}
			System.out.println("메뉴를 잘 선택하셨습니다.");
			console.printNewLine();
		}
	}

}
