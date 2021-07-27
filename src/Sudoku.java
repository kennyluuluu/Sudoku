
public class Sudoku {

	public static void main(String[] args) {
		int[][] board = new int[9][9];
		generateSolvedBoard(board);
		printBoard(board);
		if(!solve(board)) {
			System.out.println("Board is unsolvable");
		}
		printBoard(board);
	}
	
	public static Boolean solve(int[][] board) {
		if(isSolved(board))
			return true;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					for(int k = 1; k <= 9; k++) {
						board[i][j] = k;
						if(!validate(board,i,j)) {
							continue;
						}
						if(solve(board)) {
							return true;
						}
					}
					return false;
				}
			}
		}
		return false;
	}
	
	public static void generateRandomBoard(int[][] board) {
		board[0][3] = 2;
		board[0][4] = 6;
		board[0][8] = 1;
		
		board[1][0] = 6;
		board[1][1] = 8;
		board[1][7] = 9;
		
		board[2][0] = 1;
		board[2][1] = 9;
		board[2][5] = 4;
		board[2][6] = 5;
		
		board[3][0] = 8;
		board[3][1] = 2;
		board[3][3] = 1;
		board[3][7] = 4;
		
		board[4][2] = 4;
		board[4][3] = 6;
		board[4][5] = 2;
		board[4][6] = 9;
		
		board[5][1] = 5;
		board[5][5] = 3;
		board[5][7] = 2;
		board[5][8] = 8;
		
		board[6][2] = 9;
		board[6][3] = 3;
		board[6][7] = 7;
		board[6][8] = 4;
		
		board[7][1] = 4;
		board[7][4] = 5;
		board[7][7] = 3;
		board[7][8] = 6;
		
		board[8][0] = 7;
		board[8][2] = 3;
		board[8][4] = 1;
		board[8][5] = 8;
	}
	
	public static void generateSolvedBoard(int[][] board) {
		board[0][0] = 4;
		board[0][1] = 3;
		board[0][2] = 5;
		board[0][3] = 2;
		board[0][4] = 6;
		board[0][5] = 9;
		board[0][6] = 7;
		board[0][7] = 8;
		board[0][8] = 1;
		
		board[1][0] = 6;
		board[1][1] = 8;
		board[1][2] = 7;
		board[1][3] = 5;
		board[1][4] = 3;
		board[1][5] = 1;
		board[1][6] = 4;
		board[1][7] = 9;
		board[1][8] = 2;
		
		board[2][0] = 1;
		board[2][1] = 9;
		board[2][2] = 2;
		board[2][3] = 8;
		board[2][4] = 7;
		board[2][5] = 4;
		board[2][6] = 5;
		board[2][7] = 6;
		board[2][8] = 3;
		
		board[3][0] = 8;
		board[3][1] = 2;
		board[3][2] = 6;
		board[3][3] = 1;
		board[3][4] = 9;
		board[3][5] = 5;
		board[3][6] = 3;
		board[3][7] = 4;
		board[3][8] = 7;
		
		board[4][0] = 3;
		board[4][1] = 7;
		board[4][2] = 4;
		board[4][3] = 6;
		board[4][4] = 8;
		board[4][5] = 2;
		board[4][6] = 9;
		board[4][7] = 1;
		board[4][8] = 5;
		
//		board[5][0] = 9;
//		board[5][1] = 5;
		board[5][2] = 1;
//		board[5][3] = 7;
//		board[5][4] = 4;
//		board[5][5] = 3;
//		board[5][6] = 6;
		board[5][7] = 2;
		board[5][8] = 8;
		
//		board[6][0] = 5;
		board[6][1] = 1;
		board[6][2] = 9;
		board[6][3] = 3;
		board[6][4] = 2;
//		board[6][5] = 6;
//		board[6][6] = 8;
//		board[6][7] = 7;
//		board[6][8] = 4;
		
		board[7][0] = 2;
		board[7][1] = 4;
		board[7][2] = 8;
		board[7][3] = 9;
		board[7][4] = 5;
//		board[7][5] = 7;
//		board[7][6] = 1;
		board[7][7] = 3;
		board[7][8] = 6;
	
		board[8][0] = 7;
//		board[8][1] = 6;
//		board[8][2] = 3;
		board[8][3] = 4;
		board[8][4] = 1;
		board[8][5] = 8;
//		board[8][6] = 2;
//		board[8][7] = 5;
//		board[8][8] = 9;
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
//		System.out.println("Value is " + value);
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				int x2 = i*3+ii;
				int y2 = j*3+jj;
				if(x2 != x || y2 != y) {
//					System.out.println(x2 + "," + y2);
					if(board[x2][y2] == value)
						return false;
				}
			}
		}
		return true;
	}
}
