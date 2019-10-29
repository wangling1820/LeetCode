// 367. Valid Perfect Square
// https://leetcode.com/problems/valid-perfect-square/
package LeetCode;
public class PerfectSquare{
	public static void main(String[] args){
		int num = 808201;
		if (isPerfectSquare(num)) System.out.println("true");
		else System.out.println("false");

		if (isPerfectSquare(num, 1)) System.out.println("true");
		else System.out.println("false");
	}

	public static boolean isPerfectSquare(int num){
		long low = 1, high = (long) (num >> 1);
		while (low <= high){
			long mid = low + ((high - low) >> 1);
			long mul = mid * mid;
			if (mul == num) return true;
			if (mul < num) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}

        // wrong answer using int.
	public static boolean isPerfectSquare(int num, int isInt){
		int low = 1, high = num >> 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			long mul = mid * mid;
			if (mul == num) return true;
			if (mul < num) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}
}
