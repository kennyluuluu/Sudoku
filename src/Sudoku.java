
public class Sudoku {

	public static void main(String[] args) {
		System.out.println("Generating Sudoku Board...");
		int[][] board = new int[9][9];
		generateRandomBoard(board);
		printBoard(board);
	}
	
	public static void generateRandomBoard(int[][] board) {
		board[0][3] = 2;
		board[0][4] = 6;
		board[0][6] = 7;
		board[0][8] = 1;
		
		board[1][0] = 6;
		board[1][1] = 8;
		board[1][6] = 7;
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

}
