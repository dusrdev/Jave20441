package Recursion;
// import java.util.Scanner;

public class Question_howManyPaths {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q1 => Return the number of paths that lead from start to finish of the matrix
		 * while only moving from each element k by increments of k
		 */
		int[][] pathsWithK = {{1,3,1,6},
		{2,8,1,2},
		{6,2,7,5},
		{2,4,1,3}};
		System.out.println("pathsWithK = " + howManyPaths(pathsWithK)); //2

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int howManyPaths(int[][] mat) {
		boolean[][] mem = new boolean[mat.length][mat[0].length];
		return howManyPaths(mat, 0, 0, mem);
	}

	private static int howManyPaths(int[][] mat, int r, int c, boolean[][] mem) {
		// If out of bounds or already checked, we return 0 so that it doesn't count 
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mem[r][c] == true) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) { // Reached destination
			return 1;
		}
		int k = mat[r][c]; // Take k
		mem[r][c] = true; // Mark place in copy array as visited
		return howManyPaths(mat, r + k, c, mem) +
		howManyPaths(mat, r - k, c, mem) +
		howManyPaths(mat, r, c + k, mem) +
		howManyPaths(mat, r, c - k, mem);
	}

	public static int howManyPathsV2(int[][] mat) {
		return howManyPathsV2(mat, 0, 0);
	}

	/**
	 * This is a variation of the howManyPaths where we change the original array instead of copy
	 */ 
	private static int howManyPathsV2(int[][] mat, int r, int c) {
		// If out of bounds or already checked, we return 0 so that it doesn't count 
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == 0) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) { //Reached destination
			return 1;
		}
		int k = mat[r][c]; // take K
		mat[r][c] = 0; // Mark as visited
		int sum = howManyPathsV2(mat, r + k, c) +
		howManyPathsV2(mat, r - k, c) +
		howManyPathsV2(mat, r, c + k) +
		howManyPathsV2(mat, r, c - k);
		mat[r][c] = k; // Reset to default
		return sum;
	}
}