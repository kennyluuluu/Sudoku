
public class Sudoku {

	public static void main(String[] args) {
		
	}
	
	public static Boolean solve(int[][] board) {
		
	}
	
	public static void generateRandomBoard(int[][] board) {
		
	}
	
	public static void printBoard(int[][] board) {
		System.out.println(" --- --- --- --- --- --- --- --- ---");
		for(int i = 0; i < board.length; i++) {
			System.out.print("|");
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					System.out.print("   ");
				} else {
					System.out.print(' ');
					System.out.print(board[i][j]);
					System.out.print(' ');
				}
				System.out.print("|");
			}
			System.out.println("");
			System.out.println(" --- --- --- --- --- --- --- --- ---");
		}
	}

	public static Boolean isSolved(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0 || !validate(board, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static Boolean validate(int[][] board, int x, int y) {
		int value = board[x][y];
		// row and column
		for(int i = 0; i < board.length; i++) {
			if(i != x && board[i][y] == value) {
				return false;
			}
			if(i != y && board[x][i] == value) {
				return false;
			}
		}
		
		int i = x/3;
		int j = y/3;
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				int x2 = i*3+ii;
				int y2 = j*3+jj;
				if(x2 != x || y2 != y) {
					if(board[x2][y2] == value)
						return false;
				}
			}
		}
		return true;
	}
}
