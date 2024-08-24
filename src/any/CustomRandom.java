package any;
import java.util.Random;
import java.util.ArrayList;

/**
 * 랜덤 관련 도구 모음 클래스
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
public class CustomRandom {
	static Random rand = new Random();
	
	/**
	 * 정해진 범위 내 정수들 중 일부를 무작위로 뽑아 배열로 반환.
	 * @param len - 무작위로 뽑을 숫자 개수
	 * @param startNum - 범위의 시작 숫자. 해당 숫자도 범위에 포함됨.
	 * @param endNum - 범위의 끝 숫자. 해당 숫자도 범위에 포함됨.
	 * @return int[]
	 */
	public static int[] getRandomNums(int len, int startNum, int endNum) {
		int[] randNums = new int[len];
		
		for (int i = 0; i < len; i++) {
			randNums[i] = rand.nextInt(startNum, endNum);
		}
		
		return randNums;
	}
	
	/**
	 * 정해진 범위 내 정수들 중 일부를 중복되지 않게 무작위로 뽑아 배열로 반환. 
	 * @param len - 무작위로 뽑을 숫자 개수. endNum - startNum + 1 < len일 경우 len만큼만 뽑는다. 
	 * @param startNum - 범위의 시작 숫자. 해당 숫자도 범위에 포함됨.
	 * @param endNum - 범위의 끝 숫자. 해당 숫자도 범위에 포함됨.
	 * @return int[]
	 */
	public static int[] getRandomNumsNoDup(int len, int startNum, int endNum) {
		 ArrayList alNums = CustomRandom.getArrayNtoM(startNum, endNum);

		 if (endNum - startNum + 1 < len) {
			 len = endNum - startNum + 1;
		 }
		 int[] result = new int[len];
		 
		 for (int i = 0; i < len; i++) {
			 result[i] = (int) alNums.remove(
					 rand.nextInt(alNums.size())
			 );
		 }
		 
		 return result;
	}
	
	/**
	 * n부터 m까지의 연속적인 정수들로 초기화한 배열을 반환.
	 * @param n
	 * @param m
	 * @return ArrayList
	 */
	public static ArrayList getArrayNtoM(int n, int m) {
		ArrayList intArr = new ArrayList();
		
		for (int i = n; i <= m; i++) {
			intArr.add(i);
		}
		
		return intArr;
	}
	
}
