package any;
public class Rank {
	
	/**
	 * 정수들이 담긴 배열에서 가장 큰 숫자일수록 1에 가까운 랭크를 매겨 
	 * 모든 배열 요소의 랭크를 반환.
	 * @param arr - 랭크를 매길 정수가 담긴 배열
	 * @return int[] - 랭크 숫자들의 배열
	 */
	public int[] getRank(int[] arr) {
		int curRank;
		int[] rank = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			curRank = arr.length;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					--curRank;
				}
			}
			rank[i] = curRank;
		}
		
		return rank;
	}
	
}
