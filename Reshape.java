// 566. Reshape the Matrix
// https://leetcode.com/problems/reshape-the-matrix/
package LeetCode;
public class Reshape{
	public static void main(String[] args){
		int[][] nums = new int[][]{{1,2}, {3, 4}};
		printInfo(nums);
		nums = new Reshape().reshape(nums, 1, 4);
		printInfo(nums);
	}
	// the solution.
	public int[][] reshape(int[][] nums, int r, int c){
	  	int row = nums.length, col = nums[0].length;
		if (row * col != r * c){
			return nums;
		}
		// int index = 0;
		int[][] result = new int[r][c];
		for (int i=0; i<row; ++i){
			for (int j=0; j<col; ++j){
				result[(i*col+j)/c][(i*col+j)%c] = nums[i][j];
				// result[index/c][index%c] = nums[i][j];
				// ++index;
			}
		}
		return result;
	}
	public static void printInfo(int[][] nums){
		for (int[] num: nums){
			for (int n: num){
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
