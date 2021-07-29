import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = new int[9][9];
		long times = 0;
		generateRandomBoard(board);
		printBoard(board);
		long startTime = System.nanoTime();
		solve(board);
		long stopTime = System.nanoTime();
		times += (stopTime-startTime);
		System.out.println("Board Solved in " + times/10 + " nanoseconds");
		printBoard(board);
		
		
		
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,700);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
	
		
		JLabel titleText = new JLabel("Sudoku Solver");
		titleText.setFont(new Font("Serif", Font.BOLD, 40));
		titleText.setSize(400,80);
		frame.add(titleText);
		
		JPanel sudokuBoard = new JPanel();
		sudokuBoard.setBackground(Color.black);
		sudokuBoard.setBounds(100, 100, 400, 400);
		sudokuBoard.setLayout(new GridLayout(3,3,4,4));
		
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				JPanel square = new JPanel();
				square.setBackground(Color.black);
				square.setLayout(new GridLayout(3,3,1,1));
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						
						JLabel label = new JLabel(String.valueOf(board[ii*3 + i][jj*3 + j]));
						label.setBackground(Color.white);
						label.setOpaque(true);
						square.add(label);
					}
				}
				sudokuBoard.add(square);
			}
		}
		frame.add(sudokuBoard);

		JButton solveButton = new JButton("solve");
		solveButton.setBounds(0,600, 80,20);
		frame.add(solveButton);
		
		frame.setVisible(true);
	}
	
	public static Boolean solve(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					for(int k = 1; k <= 9; k++) {
						board[i][j] = k;
						if(validate(board,i,j)) {
							if(solve(board))
								return true;
						}
						board[i][j] = 0;
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
		
		for(int i = 0; i < 50; i++) {
			x = rand.nextInt(9);
			y = rand.nextInt(9);
			board[x][y] = 0;
		}
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
