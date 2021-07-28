import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = new int[9][9];
		generateRandomBoard(board);
		
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,700);
		
		JButton button = new JButton("Solve");
		frame.getContentPane().add(button);
		frame.getContentPane().setBackground(Color.black);

		
		
		Container con = frame.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBounds(100,100, 400, 400);
		panel.setBackground(Color.white);
		con.add(panel);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static Boolean solve(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					for(int k = 1; k <= 9; k++) {
						board[i][j] = k;
						if(!validate(board,i,j)) {
							board[i][j] = 0;
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
		if(isSolved(board))
			return true;
		return false;
	}
	
	public static void generateRandomBoard(int[][] board) {
		Random rand = new Random();
		int r = rand.nextInt(9) + 1;
		int x = rand.nextInt(9);
		int y = rand.nextInt(9);
		board[x][y] = r;
		solve(board);
		
		for(int i = 0; i < 60; i++) {
			x = rand.nextInt(9);
			y = rand.nextInt(9);
			board[x][y] = 0;
		}
		printBoard(board);
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
