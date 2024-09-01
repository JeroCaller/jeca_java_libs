package jeca.any;
import java.util.Arrays;

/**
 * 배열을 모두 출력하기 위한 유틸리티 클래스.
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
 */
public class PrintArrayToolStatic {
	
	/**
	 * 객체 생성 방지
	 */
	private PrintArrayToolStatic() {}
	
	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printArray(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printArray(char[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printArray(String[] arr) {
		System.out.println("{");
		for (String oneStr : arr) {
			System.out.println("    " + "\"" + oneStr + "\",");
		}
		System.out.println("}");
	}
	
}
